import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adrianaxente on 15.08.2014.
 */
public class ComputersSQLightHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;

    private static final String COMPUTER_NAME_COLUMN = "CMP_NAME";
    private static final String COMPUTER_ADDRESS_COLUMN = "CMP_ADDRESS";
    private static final String COMPUTER_MAC_ADDRESS_COLUMN = "CMP_MAC";
    private static final String COMPUTER_PORT_COLUMN = "CMP_PORT";


    private static final String DATABASE_NAME = "Main";
    private static final String COMPUTER_TABLE_NAME = "COMPUTER";
    private static final String COMPUTER_TABLE_CREATE =
            "CREATE TABLE " + COMPUTER_TABLE_NAME +
                    " (" +
                        COMPUTER_NAME_COLUMN         +   " TEXT, "  +
                        COMPUTER_ADDRESS_COLUMN      +   " TEXT, "  +
                        COMPUTER_MAC_ADDRESS_COLUMN  +   " TEXT, "  +
                        COMPUTER_PORT_COLUMN         +   " INTEGER" +
                    ");";


    ComputersSQLightHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMPUTER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
