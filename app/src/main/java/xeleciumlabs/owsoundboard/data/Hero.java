package xeleciumlabs.owsoundboard.data;

/**
 * Created by Xelecium on 10/24/2016.
 *  Class for OverWatch Heroes. Contains Resource IDs for images and voice lines.
 */
public class Hero {

    private String mName;   //String for Hero name
    private int mHeroPic;   //ID for Hero pic
    private int mUltSound;  //ID for Ultimate sfx
    private int mUltPic;    //ID for Ultimate pic

    Hero(String name, int heroPic, int ultSound, int ultPic) {
        mName = name;
        mHeroPic = heroPic;
        mUltSound = ultSound;
        mUltPic = ultPic;
    }

    public String getName() {return mName;}

    public int getHeroPic() {return mHeroPic;}

    public int getUltPic() {return mUltPic;}

    public int getUltSound() {return mUltSound;}
}
