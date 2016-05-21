package pe.cibertec.demo01.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android-SAB-PM on 21/05/2016.
 */
public class Person implements Parcelable {

    private int personId;
    private String name;
    private String lastName;
    private String doc;
    private int age;
    private String phone;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.personId);
        dest.writeString(this.name);
        dest.writeString(this.lastName);
        dest.writeString(this.doc);
        dest.writeInt(this.age);
        dest.writeString(this.phone);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.personId = in.readInt();
        this.name = in.readString();
        this.lastName = in.readString();
        this.doc = in.readString();
        this.age = in.readInt();
        this.phone = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
