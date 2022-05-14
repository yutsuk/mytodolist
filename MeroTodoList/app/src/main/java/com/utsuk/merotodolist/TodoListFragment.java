package com.utsuk.merotodolist;
/*
 * Utsuk Paudayal
 * C7227233
 */
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.utsuk.merotodolist.model.ETodo;
import com.utsuk.merotodolist.viewmodel.TodoViewModel;

import java.text.SimpleDateFormat;
import java.util.List;

public class TodoListFragment extends Fragment {
    View rootView;
    private TodoViewModel mTodoViewModel;
    RecyclerView todoRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
     rootView = inflater.inflate(R.layout.fragment_todo_list, container, false);
        mTodoViewModel = ViewModelProviders.of(this).get(TodoViewModel.class);
        todoRecyclerView = rootView.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        todoRecyclerView.setLayoutManager(layoutManager);
        todoRecyclerView.setHasFixedSize(true);

        updateRV();
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                List<ETodo> todoList = mTodoViewModel.getAllTodos().getValue();
                TodoAdapter adapter = new TodoAdapter(todoList);
                ETodo todo = adapter.getTodo(viewHolder.getAdapterPosition());
                mTodoViewModel.deleteById(todo);

            }
        }).attachToRecyclerView(todoRecyclerView);
        return rootView;
    }
    void updateRV(){
        mTodoViewModel.getAllTodos().observe(this, new Observer<List<ETodo>>() {
            @Override
            public void onChanged(List<ETodo> todoList) {
                TodoAdapter adapter = new TodoAdapter(todoList);
                todoRecyclerView.setAdapter(adapter);
            }
        });
    }
    private class TodoAdapter extends RecyclerView.Adapter<TodoHolder>{
        List<ETodo> mTodoList;
        public TodoAdapter(List<ETodo> todoList){
            mTodoList = todoList;
        }
        @NonNull
        @Override
        public TodoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            return new TodoHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull TodoHolder holder, int position) {
            ETodo todo = mTodoList.get(position);
            LinearLayout layout = (LinearLayout)((ViewGroup)holder.mTitle.getParent());
            switch (todo.getPriority()){
                case 1:
                    layout.setBackgroundColor(getResources().getColor(R.color.color_high_priority));
                    break;
                case 2:
                    layout.setBackgroundColor(getResources().getColor(R.color.color_medium_priority));
                    break;
                case 3:
                    layout.setBackgroundColor(getResources().getColor(R.color.color_low_priority));
                    break;
            }
            holder.bind(todo);
        }
        @Override
        public int getItemCount() {
            return mTodoList.size();
        }
        public ETodo getTodo(int index){
            return mTodoList.get(index);
        }

        public ETodo getTodoAt(int index){
            return mTodoList.get(index);
        }
    }
    private class TodoHolder extends RecyclerView.ViewHolder{
        TextView mTitle, mDate, mDesprition;
        public TodoHolder(LayoutInflater inflater, ViewGroup parentViewGroup) {
            super(inflater.inflate(R.layout.list_item_todo, parentViewGroup, false));
            mTitle = itemView.findViewById(R.id.list_title);
            mDate = itemView.findViewById(R.id.list_date);
            mDesprition=itemView.findViewById(R.id.list_description);


            mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TodoAdapter adapter = new TodoAdapter(mTodoViewModel.getAllTodos().getValue());
                    int position = getAdapterPosition();
                    ETodo eTodo= adapter.getTodoAt(position);
                    Intent intent = new Intent(getActivity(),EditTodoActivity.class);
                    intent.putExtra("TodoId", eTodo.getId());
                    startActivity(intent);
                }
            });
            mDesprition.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TodoAdapter adapter = new TodoAdapter(mTodoViewModel.getAllTodos().getValue());
                    int position = getAdapterPosition();
                    ETodo eTodo= adapter.getTodoAt(position);
                    Intent intent = new Intent(getActivity(),EditTodoActivity.class);
                    intent.putExtra("TodoId", eTodo.getId());
                    startActivity(intent);
                }
            });
            mDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TodoAdapter adapter = new TodoAdapter(mTodoViewModel.getAllTodos().getValue());
                    int position = getAdapterPosition();
                    ETodo eTodo= adapter.getTodoAt(position);
                    Intent intent = new Intent(getActivity(),EditTodoActivity.class);
                    intent.putExtra("TodoId", eTodo.getId());
                    startActivity(intent);
                }
            });
        }
        public void bind(ETodo todo){
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            mTitle.setText(todo.getTitle());
            mDesprition.setText(todo.getDescription());
            mDate.setText(dateFormatter.format(todo.getTodo_date()));
        }

    }




}