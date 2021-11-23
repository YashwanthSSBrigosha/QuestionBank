package com.example.questionbank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>{

    ArrayList<Questions> questionInfo;
    ArrayList<Questions> queFull;

    public QuestionAdapter(ArrayList<Questions> questionInfo) {
        this.questionInfo = questionInfo;
        queFull = new ArrayList<>(questionInfo);
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_card,parent,false);
        QuestionViewHolder qvh = new QuestionViewHolder(view);
        return qvh;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {

        com.example.questionbank.Questions currentQue = questionInfo.get(position);

        holder.queTitle.setText(currentQue.getTitle());
        holder.queIcon.setImageResource(currentQue.getImgRes());

    }

    @Override
    public int getItemCount() {
        return questionInfo.size();
    }

    public Filter getFilter() {
        return queFilter;
    }

    private Filter queFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Questions> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(queFull);
            }
            else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                for (Questions question:queFull
                ) {
                    if (question.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(question);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            questionInfo.clear();
            questionInfo.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };

    public class QuestionViewHolder extends RecyclerView.ViewHolder{

        ImageView queIcon;
        TextView queTitle;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);

            queIcon = itemView.findViewById(R.id.queIcon);
            queTitle = itemView.findViewById(R.id.queTitle);
        }
    }
}
