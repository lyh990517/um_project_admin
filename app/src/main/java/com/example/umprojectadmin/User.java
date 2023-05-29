package com.example.umprojectadmin;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{
    private String name;
    private int age;
    private String address;
    private String rating;
    private int warningCount;
    private int imageResId;
    private OnItemClickListener listener;

    public User(String name, int age, String address, String rating, int warningCount, int imageResId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rating = rating;
        this.warningCount = warningCount;
        this.imageResId = imageResId;
    }

    // Parcelable 인터페이스의 메소드 구현
    protected User(Parcel in) {
        name = in.readString();
        age = in.readInt();
        address = in.readString();
        rating = in.readString();
        warningCount = in.readInt();
        imageResId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);
        dest.writeString(rating);
        dest.writeInt(warningCount);
        dest.writeInt(imageResId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getRating() {
        return rating;
    }

    public int getWarningCount() {
        return warningCount;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", rating='" + rating + '\'' +
                ", warningCount=" + warningCount +
                ", imageResId=" + imageResId +
                '}';
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void onItemClick() {
        if (listener != null) {
            listener.onItemClick(this);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(User user);
    }

}
