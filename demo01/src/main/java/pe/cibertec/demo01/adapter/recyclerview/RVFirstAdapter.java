package pe.cibertec.demo01.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.cibertec.demo01.R;
import pe.cibertec.demo01.entities.Person;

/**
 * Created by Android-SAB-PM on 21/05/2016.
 */
public class RVFirstAdapter extends RecyclerView.Adapter<RVFirstAdapter.RVFirstAdapterViewHolder> {
    private ArrayList<Person> mLstPerson;

    public RVFirstAdapter() {
        mLstPerson = new ArrayList<>();
    }

    public void add(Person person) {
        mLstPerson.add(person);
        notifyItemInserted(mLstPerson.size() - 1);
    }

    @Override
    public RVFirstAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVFirstAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.first_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RVFirstAdapterViewHolder holder, int position) {
        Person person = mLstPerson.get(position);
        holder.tvFirstItemFullName.setText(person.getName() + " " + person.getLastName());
        holder.tvFirstItemAge.setText(String.valueOf(person.getAge()));
        holder.tvFirstItemDoc.setText(person.getDoc());
        holder.tvFirstItemPhone.setText(person.getPhone());
    }

    @Override
    public int getItemCount() {
        return mLstPerson.size();
    }

    static class RVFirstAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView tvFirstItemFullName, tvFirstItemDoc, tvFirstItemAge, tvFirstItemPhone;

        public RVFirstAdapterViewHolder(View itemView) {
            super(itemView);

            tvFirstItemFullName = (TextView) itemView.findViewById(R.id.tvFirstItemFullName);
            tvFirstItemDoc = (TextView) itemView.findViewById(R.id.tvFirstItemDoc);
            tvFirstItemAge = (TextView) itemView.findViewById(R.id.tvFirstItemAge);
            tvFirstItemPhone = (TextView) itemView.findViewById(R.id.tvFirstItemPhone);
        }
    }
}
