package com.liraz.cookit.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.liraz.cookit.R;
import com.liraz.cookit.model.Model;
import com.liraz.cookit.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class MyRecipesList extends Fragment {

    String userId;
    RecyclerView list;
    List<Recipe> data = new LinkedList<>();
    MyRecipesList.MyRecipeListAdapter adapter;
    MyRecipesListViewModel viewModel;
    LiveData<List<Recipe>> liveData;



    public MyRecipesList(){}

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        viewModel = new ViewModelProvider(this).get(MyRecipesListViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_recipes_list, container, false);


        //recipe = MyRecipesListArgs.fromBundle(getArguments()).getUserId();


        list= view.findViewById(R.id.my_recipes_list);
        list.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(layoutManager);

        adapter = new MyRecipeListAdapter();

        list.setAdapter(adapter);

//        adapter.setOnClickListener(new Rec_List_Fragment.OnItemClickListener() {
//            @Override
//            public void onClick(int position) {
//                Recipe recipe = data.get(position);
//                Rec_List_FragmentDirections.ActionRecListToRecipePage action = Rec_List_FragmentDirections.actionRecListToRecipePage(recipe);
//                Navigation.findNavController(view).navigate(action);
//            }
//        });

        //live data
        liveData = viewModel.getDataByUser(userId);
        liveData.observe(getViewLifecycleOwner(), new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {

                List<Recipe> reversedData = reverseData(recipes);
                data = reversedData;
                adapter.notifyDataSetChanged();
            }
        });


        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.my_recipes_list_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.refresh(new Model.CompListener() {
                    @Override
                    public void onComplete() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });

        return view;
    }

    private List<Recipe> reverseData(List<Recipe> recipes) {
        List<Recipe> reversedData = new LinkedList<>();
        for (Recipe recipe: recipes) {
            reversedData.add(0, recipe);
        }
        return reversedData;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    static class MyRecipeViewHolder extends RecyclerView.ViewHolder {

        TextView recipeTitle;
        ImageView recipeImg;
        TextView username;
        ProgressBar progressBar;
        Recipe recipe;

        public MyRecipeViewHolder(@NonNull View itemView, final MyRecipesList.OnItemClickListener listener) {
            super(itemView);

            recipeTitle = itemView.findViewById(R.id.my_recipes_list_row_title_text_view);
            recipeImg = itemView.findViewById(R.id.my_recipes_list_row_image_view);
            username = itemView.findViewById(R.id.my_recipes_list_row_username_text_view);
            progressBar = itemView.findViewById(R.id.my_recipes_list_row_progress_bar);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                            listener.onClick(position);
                    }
                }
            });
        }

        public void bind(Recipe recipeToBind){
            recipeTitle.setText(recipeToBind.recipeName);
            username.setText(recipeToBind.username);
            recipe = recipeToBind;
            if (recipeToBind.recipeImgUrl !=null)
            {
                Picasso.get().load(recipeToBind.recipeImgUrl).placeholder(R.drawable.recipe_pic_placeholder).into(recipeImg);
            }else {
                recipeImg.setImageResource(R.drawable.ic_launcher_background);
            }

        }
    }

    interface OnItemClickListener {
        void onClick(int position);
    }


    class MyRecipeListAdapter extends RecyclerView.Adapter<MyRecipeViewHolder> {

        private OnItemClickListener listener;

        void setOnClickListener(OnItemClickListener listener){ this.listener=listener; }

        @NonNull
        @Override
        public MyRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //create row
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_my_recipes_row,parent,false);
            MyRecipesList.MyRecipeViewHolder myrecipeViewHolder = new MyRecipesList.MyRecipeViewHolder(view,listener);
            return myrecipeViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecipeViewHolder holder, int position) {
            Recipe recipe = data.get(position);
            holder.bind(recipe);
        }


        @Override
        public int getItemCount() {return data.size();}
    }

}
