package com.example.workouttracker.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.workouttracker.data.dao.WorkoutDao;
import com.example.workouttracker.data.dao.WorkoutDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WorkoutDatabase_Impl extends WorkoutDatabase {
  private volatile WorkoutDao _workoutDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(9) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `workout_type` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `exercise` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `workoutTypeId` INTEGER NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `repRange` TEXT NOT NULL, `description` TEXT, FOREIGN KEY(`workoutTypeId`) REFERENCES `workout_type`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_exercise_workoutTypeId` ON `exercise` (`workoutTypeId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `workout_session` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `exerciseId` INTEGER NOT NULL, `date` INTEGER NOT NULL, `sets` INTEGER NOT NULL, `reps` INTEGER NOT NULL, `weight` REAL, `time` INTEGER, `notes` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `personal_record` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `exerciseId` INTEGER NOT NULL, `recordType` TEXT NOT NULL, `value` REAL NOT NULL, `date` INTEGER NOT NULL, `notes` TEXT, FOREIGN KEY(`exerciseId`) REFERENCES `exercise`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_personal_record_exerciseId` ON `personal_record` (`exerciseId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_settings` (`id` INTEGER NOT NULL, `dark_theme` INTEGER NOT NULL, `auto_weight_increment` REAL NOT NULL, `default_rest_time` INTEGER NOT NULL, `units` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `exercise_library` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `muscleGroups` TEXT NOT NULL, `equipment` TEXT NOT NULL, `difficulty` TEXT NOT NULL, `instructions` TEXT, `isActive` INTEGER NOT NULL, `isDefault` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `set_tracking` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `workoutSessionId` INTEGER NOT NULL, `exerciseId` INTEGER NOT NULL, `setNumber` INTEGER NOT NULL, `targetReps` INTEGER NOT NULL, `actualReps` INTEGER NOT NULL, `weight` REAL NOT NULL, `isSuccessful` INTEGER NOT NULL, `rpe` INTEGER, FOREIGN KEY(`workoutSessionId`) REFERENCES `workout_session`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`exerciseId`) REFERENCES `exercise`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_set_tracking_workoutSessionId` ON `set_tracking` (`workoutSessionId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_set_tracking_exerciseId` ON `set_tracking` (`exerciseId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f32dca5eda971a699b52cc45043e97f7')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `workout_type`");
        db.execSQL("DROP TABLE IF EXISTS `exercise`");
        db.execSQL("DROP TABLE IF EXISTS `workout_session`");
        db.execSQL("DROP TABLE IF EXISTS `personal_record`");
        db.execSQL("DROP TABLE IF EXISTS `user_settings`");
        db.execSQL("DROP TABLE IF EXISTS `exercise_library`");
        db.execSQL("DROP TABLE IF EXISTS `set_tracking`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsWorkoutType = new HashMap<String, TableInfo.Column>(3);
        _columnsWorkoutType.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutType.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutType.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkoutType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkoutType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkoutType = new TableInfo("workout_type", _columnsWorkoutType, _foreignKeysWorkoutType, _indicesWorkoutType);
        final TableInfo _existingWorkoutType = TableInfo.read(db, "workout_type");
        if (!_infoWorkoutType.equals(_existingWorkoutType)) {
          return new RoomOpenHelper.ValidationResult(false, "workout_type(com.example.workouttracker.data.entity.WorkoutType).\n"
                  + " Expected:\n" + _infoWorkoutType + "\n"
                  + " Found:\n" + _existingWorkoutType);
        }
        final HashMap<String, TableInfo.Column> _columnsExercise = new HashMap<String, TableInfo.Column>(6);
        _columnsExercise.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("workoutTypeId", new TableInfo.Column("workoutTypeId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("repRange", new TableInfo.Column("repRange", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExercise = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysExercise.add(new TableInfo.ForeignKey("workout_type", "CASCADE", "NO ACTION", Arrays.asList("workoutTypeId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesExercise = new HashSet<TableInfo.Index>(1);
        _indicesExercise.add(new TableInfo.Index("index_exercise_workoutTypeId", false, Arrays.asList("workoutTypeId"), Arrays.asList("ASC")));
        final TableInfo _infoExercise = new TableInfo("exercise", _columnsExercise, _foreignKeysExercise, _indicesExercise);
        final TableInfo _existingExercise = TableInfo.read(db, "exercise");
        if (!_infoExercise.equals(_existingExercise)) {
          return new RoomOpenHelper.ValidationResult(false, "exercise(com.example.workouttracker.data.entity.Exercise).\n"
                  + " Expected:\n" + _infoExercise + "\n"
                  + " Found:\n" + _existingExercise);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkoutSession = new HashMap<String, TableInfo.Column>(8);
        _columnsWorkoutSession.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSession.put("exerciseId", new TableInfo.Column("exerciseId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSession.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSession.put("sets", new TableInfo.Column("sets", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSession.put("reps", new TableInfo.Column("reps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSession.put("weight", new TableInfo.Column("weight", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSession.put("time", new TableInfo.Column("time", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutSession.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkoutSession = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkoutSession = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkoutSession = new TableInfo("workout_session", _columnsWorkoutSession, _foreignKeysWorkoutSession, _indicesWorkoutSession);
        final TableInfo _existingWorkoutSession = TableInfo.read(db, "workout_session");
        if (!_infoWorkoutSession.equals(_existingWorkoutSession)) {
          return new RoomOpenHelper.ValidationResult(false, "workout_session(com.example.workouttracker.data.entity.WorkoutSession).\n"
                  + " Expected:\n" + _infoWorkoutSession + "\n"
                  + " Found:\n" + _existingWorkoutSession);
        }
        final HashMap<String, TableInfo.Column> _columnsPersonalRecord = new HashMap<String, TableInfo.Column>(6);
        _columnsPersonalRecord.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPersonalRecord.put("exerciseId", new TableInfo.Column("exerciseId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPersonalRecord.put("recordType", new TableInfo.Column("recordType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPersonalRecord.put("value", new TableInfo.Column("value", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPersonalRecord.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPersonalRecord.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPersonalRecord = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPersonalRecord.add(new TableInfo.ForeignKey("exercise", "CASCADE", "NO ACTION", Arrays.asList("exerciseId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPersonalRecord = new HashSet<TableInfo.Index>(1);
        _indicesPersonalRecord.add(new TableInfo.Index("index_personal_record_exerciseId", false, Arrays.asList("exerciseId"), Arrays.asList("ASC")));
        final TableInfo _infoPersonalRecord = new TableInfo("personal_record", _columnsPersonalRecord, _foreignKeysPersonalRecord, _indicesPersonalRecord);
        final TableInfo _existingPersonalRecord = TableInfo.read(db, "personal_record");
        if (!_infoPersonalRecord.equals(_existingPersonalRecord)) {
          return new RoomOpenHelper.ValidationResult(false, "personal_record(com.example.workouttracker.data.entity.PersonalRecord).\n"
                  + " Expected:\n" + _infoPersonalRecord + "\n"
                  + " Found:\n" + _existingPersonalRecord);
        }
        final HashMap<String, TableInfo.Column> _columnsUserSettings = new HashMap<String, TableInfo.Column>(5);
        _columnsUserSettings.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("dark_theme", new TableInfo.Column("dark_theme", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("auto_weight_increment", new TableInfo.Column("auto_weight_increment", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("default_rest_time", new TableInfo.Column("default_rest_time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserSettings.put("units", new TableInfo.Column("units", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserSettings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserSettings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserSettings = new TableInfo("user_settings", _columnsUserSettings, _foreignKeysUserSettings, _indicesUserSettings);
        final TableInfo _existingUserSettings = TableInfo.read(db, "user_settings");
        if (!_infoUserSettings.equals(_existingUserSettings)) {
          return new RoomOpenHelper.ValidationResult(false, "user_settings(com.example.workouttracker.data.entity.UserSettings).\n"
                  + " Expected:\n" + _infoUserSettings + "\n"
                  + " Found:\n" + _existingUserSettings);
        }
        final HashMap<String, TableInfo.Column> _columnsExerciseLibrary = new HashMap<String, TableInfo.Column>(9);
        _columnsExerciseLibrary.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseLibrary.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseLibrary.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseLibrary.put("muscleGroups", new TableInfo.Column("muscleGroups", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseLibrary.put("equipment", new TableInfo.Column("equipment", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseLibrary.put("difficulty", new TableInfo.Column("difficulty", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseLibrary.put("instructions", new TableInfo.Column("instructions", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseLibrary.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseLibrary.put("isDefault", new TableInfo.Column("isDefault", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExerciseLibrary = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExerciseLibrary = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExerciseLibrary = new TableInfo("exercise_library", _columnsExerciseLibrary, _foreignKeysExerciseLibrary, _indicesExerciseLibrary);
        final TableInfo _existingExerciseLibrary = TableInfo.read(db, "exercise_library");
        if (!_infoExerciseLibrary.equals(_existingExerciseLibrary)) {
          return new RoomOpenHelper.ValidationResult(false, "exercise_library(com.example.workouttracker.data.entity.ExerciseLibrary).\n"
                  + " Expected:\n" + _infoExerciseLibrary + "\n"
                  + " Found:\n" + _existingExerciseLibrary);
        }
        final HashMap<String, TableInfo.Column> _columnsSetTracking = new HashMap<String, TableInfo.Column>(9);
        _columnsSetTracking.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSetTracking.put("workoutSessionId", new TableInfo.Column("workoutSessionId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSetTracking.put("exerciseId", new TableInfo.Column("exerciseId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSetTracking.put("setNumber", new TableInfo.Column("setNumber", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSetTracking.put("targetReps", new TableInfo.Column("targetReps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSetTracking.put("actualReps", new TableInfo.Column("actualReps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSetTracking.put("weight", new TableInfo.Column("weight", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSetTracking.put("isSuccessful", new TableInfo.Column("isSuccessful", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSetTracking.put("rpe", new TableInfo.Column("rpe", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSetTracking = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysSetTracking.add(new TableInfo.ForeignKey("workout_session", "CASCADE", "NO ACTION", Arrays.asList("workoutSessionId"), Arrays.asList("id")));
        _foreignKeysSetTracking.add(new TableInfo.ForeignKey("exercise", "CASCADE", "NO ACTION", Arrays.asList("exerciseId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSetTracking = new HashSet<TableInfo.Index>(2);
        _indicesSetTracking.add(new TableInfo.Index("index_set_tracking_workoutSessionId", false, Arrays.asList("workoutSessionId"), Arrays.asList("ASC")));
        _indicesSetTracking.add(new TableInfo.Index("index_set_tracking_exerciseId", false, Arrays.asList("exerciseId"), Arrays.asList("ASC")));
        final TableInfo _infoSetTracking = new TableInfo("set_tracking", _columnsSetTracking, _foreignKeysSetTracking, _indicesSetTracking);
        final TableInfo _existingSetTracking = TableInfo.read(db, "set_tracking");
        if (!_infoSetTracking.equals(_existingSetTracking)) {
          return new RoomOpenHelper.ValidationResult(false, "set_tracking(com.example.workouttracker.data.entity.SetTracking).\n"
                  + " Expected:\n" + _infoSetTracking + "\n"
                  + " Found:\n" + _existingSetTracking);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f32dca5eda971a699b52cc45043e97f7", "5b2447193775409ef06cbd567075d450");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "workout_type","exercise","workout_session","personal_record","user_settings","exercise_library","set_tracking");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `workout_type`");
      _db.execSQL("DELETE FROM `exercise`");
      _db.execSQL("DELETE FROM `workout_session`");
      _db.execSQL("DELETE FROM `personal_record`");
      _db.execSQL("DELETE FROM `user_settings`");
      _db.execSQL("DELETE FROM `exercise_library`");
      _db.execSQL("DELETE FROM `set_tracking`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(WorkoutDao.class, WorkoutDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public WorkoutDao workoutDao() {
    if (_workoutDao != null) {
      return _workoutDao;
    } else {
      synchronized(this) {
        if(_workoutDao == null) {
          _workoutDao = new WorkoutDao_Impl(this);
        }
        return _workoutDao;
      }
    }
  }
}
