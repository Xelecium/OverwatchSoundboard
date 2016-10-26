package xeleciumlabs.owsoundboard.data;

/**
 * Created by Xelecium on 10/24/2016.
 */
public class Hero {

    private String mName;   //String for name
    private int mPic;       //Drawable ID for pic
    private long mHello;    //ID for hello sfx
    private long mReady;    //ID for ultimate ready sfx
    private long mUltimate; //ID for ultimate sfx

    public Hero (String name, int pic, long hello, long ready, long ultimate) {
        mName = name;
        mPic = pic;
        mHello = hello;
        mReady = ready;
        mUltimate = ultimate;
    }
}
