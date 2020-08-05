# Retrofit-use-get-Data-of-Server-
In project using get Users Data like- Id, UserId,Body,Title etc.
In project creat 3 type of class (DataModel, DataAdapter, Interface).
I work for RecyclerView in shows multiple of Data.

#*# Two Dependencies Adds
implementation 'com.squareup.retrofit2:retrofit:2.8.2'
implementation 'com.squareup.retrofit2:converter-gson:2.8.2'
implementation 'com.android.support:recyclerview-v7:28.0.0'


#Fist work.

@ I am Show to DataModel.
package com.sundar.jsongetdata;

public class DataModel {

    private int userId,id;
    private String title, body;

    public DataModel(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

.

#Second work.(Create Data Adapte)

package com.sundar.jsongetdata;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context context;
    List<DataModel> dataModelList;

    public DataAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(dataModelList.get(position).getTitle());
        holder.body.setText(dataModelList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, idn, body,title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = (TextView) itemView.findViewById(R.id.userId);
            idn = (TextView) itemView.findViewById(R.id.idn);
            body = (TextView) itemView.findViewById(R.id.body);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}

#Third Work(Create Interface)
package com.sundar.jsongetdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataInterface {

    @GET("posts")
    Call<List<DataModel>> getAllData();
}
