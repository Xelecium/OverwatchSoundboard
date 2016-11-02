package xeleciumlabs.owsoundboard.data;

/**
 * Created by Xelecium on 10/24/2016.
 */
public class Hero {

    private String mName;   //String for name
    private int mHeroPic;       //Drawable ID for pic
    private int mUltSound; //ID for ultimate sfx
    private int mUltPic;    //ID for hello sfx

    public Hero (String name, int heroPic, int ultSound, int ultPic) {
        mName = name;
        mHeroPic = heroPic;
        mUltSound = ultSound;
        mUltPic = ultPic;
    }

    public String getName() {return mName;}

    public void setName(String name) {mName = name;}

    public int getHeroPic() {return mHeroPic;}

    public void setHeroPic(int heroPic) {
        mHeroPic = heroPic;}

    public int getUltPic() {return mUltPic;}

    public void setUltPic(int ultPic) {
        mUltPic = ultPic;}

    public int getUltSound() {return mUltSound;}

    public void setUltSound(int ultSound) {
        mUltSound = ultSound;}
}
