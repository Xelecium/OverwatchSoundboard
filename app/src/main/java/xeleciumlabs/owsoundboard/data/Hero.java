package xeleciumlabs.owsoundboard.data;

/**
 * Created by Xelecium on 10/24/2016.
 */
public class Hero {

    private String mName;   //String for name
    private int mPic;       //Drawable ID for pic
    private int mHello;    //ID for hello sfx
    private int mReady;    //ID for ultimate ready sfx
    private int mUltimate; //ID for ultimate sfx

    public Hero (String name, int pic, int hello, int ready, int ultimate) {
        mName = name;
        mPic = pic;
        mHello = hello;
        mReady = ready;
        mUltimate = ultimate;
    }

    public String getName() {return mName;}

    public void setName(String name) {mName = name;}

    public int getPic() {return mPic;}

    public void setPic(int pic) {mPic = pic;}

    public int getHello() {return mHello;}

    public void setHello(int hello) {mHello = hello;}

    public int getReady() {return mReady;}

    public void setReady(int ready) {mReady = ready;}

    public int getUltimate() {return mUltimate;}

    public void setUltimate(int ultimate) {mUltimate = ultimate;}
}
