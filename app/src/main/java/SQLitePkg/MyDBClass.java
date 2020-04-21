package SQLitePkg;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

import RecyclerPkg.DBModelClass;

public class MyDBClass extends SQLiteAssetHelper {
    private static final String DATABASE_NAME="MyDB.db";
    private static final int DATABASE_VERSTION=1;
    Context context;
    public MyDBClass(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSTION);
       this.context=context;
    }
   public ArrayList<DBModelClass> getAllData(){
        try {
            ArrayList<DBModelClass> objDbModelclasArrayList=new ArrayList<>();
            SQLiteDatabase objsqLiteDatabase=getReadableDatabase();
            if(objsqLiteDatabase!=null){
            Cursor objcursor= objsqLiteDatabase.rawQuery("select * from taskdata",null);
              if (objcursor.getCount()!=0)
              {
                  while (objcursor.moveToNext())
                  {
                      String imageDes=objcursor.getString(0);
                      byte[] imagesByte=objcursor.getBlob(1);
                      Bitmap ourimage= BitmapFactory.decodeByteArray(imagesByte,0,imagesByte.length);
                      objDbModelclasArrayList.add(
                              new DBModelClass(
                                      imageDes,ourimage

                              )
                      );
                  }
                  return objDbModelclasArrayList;
              }
              else
              {
                  Toast.makeText(context, "no data is retrived", Toast.LENGTH_SHORT).show();
              return null;
              }
            }else
            {
                Toast.makeText(context, "Data base is null", Toast.LENGTH_SHORT).show();
            return null;
            }
        }catch (Exception e){
            Toast.makeText(context, "getAllData"+e.getMessage(), Toast.LENGTH_SHORT).show();
        return null;
        }
   }

}
