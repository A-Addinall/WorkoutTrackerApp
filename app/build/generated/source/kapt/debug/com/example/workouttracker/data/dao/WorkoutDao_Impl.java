package com.example.workouttracker.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.workouttracker.data.entity.Exercise;
import com.example.workouttracker.data.entity.ExerciseLibrary;
import com.example.workouttracker.data.entity.PersonalRecord;
import com.example.workouttracker.data.entity.SetTracking;
import com.example.workouttracker.data.entity.UserSettings;
import com.example.workouttracker.data.entity.WorkoutSession;
import com.example.workouttracker.data.entity.WorkoutType;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WorkoutDao_Impl implements WorkoutDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WorkoutType> __insertionAdapterOfWorkoutType;

  private final EntityInsertionAdapter<Exercise> __insertionAdapterOfExercise;

  private final EntityInsertionAdapter<WorkoutSession> __insertionAdapterOfWorkoutSession;

  private final EntityInsertionAdapter<SetTracking> __insertionAdapterOfSetTracking;

  private final EntityInsertionAdapter<PersonalRecord> __insertionAdapterOfPersonalRecord;

  private final EntityInsertionAdapter<UserSettings> __insertionAdapterOfUserSettings;

  private final EntityInsertionAdapter<ExerciseLibrary> __insertionAdapterOfExerciseLibrary;

  private final EntityDeletionOrUpdateAdapter<Exercise> __deletionAdapterOfExercise;

  private final EntityDeletionOrUpdateAdapter<UserSettings> __updateAdapterOfUserSettings;

  private final EntityDeletionOrUpdateAdapter<ExerciseLibrary> __updateAdapterOfExerciseLibrary;

  private final SharedSQLiteStatement __preparedStmtOfDeleteExerciseById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveDuplicateExercisesByName;

  public WorkoutDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWorkoutType = new EntityInsertionAdapter<WorkoutType>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `workout_type` (`id`,`name`,`description`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WorkoutType entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
      }
    };
    this.__insertionAdapterOfExercise = new EntityInsertionAdapter<Exercise>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `exercise` (`id`,`workoutTypeId`,`name`,`category`,`repRange`,`description`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Exercise entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getWorkoutTypeId());
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getRepRange() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getRepRange());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDescription());
        }
      }
    };
    this.__insertionAdapterOfWorkoutSession = new EntityInsertionAdapter<WorkoutSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `workout_session` (`id`,`exerciseId`,`date`,`sets`,`reps`,`weight`,`time`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WorkoutSession entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getExerciseId());
        statement.bindLong(3, entity.getDate());
        statement.bindLong(4, entity.getSets());
        statement.bindLong(5, entity.getReps());
        if (entity.getWeight() == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.getWeight());
        }
        if (entity.getTime() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getTime());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getNotes());
        }
      }
    };
    this.__insertionAdapterOfSetTracking = new EntityInsertionAdapter<SetTracking>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `set_tracking` (`id`,`workoutSessionId`,`exerciseId`,`setNumber`,`targetReps`,`actualReps`,`weight`,`isSuccessful`,`rpe`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SetTracking entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getWorkoutSessionId());
        statement.bindLong(3, entity.getExerciseId());
        statement.bindLong(4, entity.getSetNumber());
        statement.bindLong(5, entity.getTargetReps());
        statement.bindLong(6, entity.getActualReps());
        statement.bindDouble(7, entity.getWeight());
        final int _tmp = entity.isSuccessful() ? 1 : 0;
        statement.bindLong(8, _tmp);
        if (entity.getRpe() == null) {
          statement.bindNull(9);
        } else {
          statement.bindDouble(9, entity.getRpe());
        }
      }
    };
    this.__insertionAdapterOfPersonalRecord = new EntityInsertionAdapter<PersonalRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `personal_record` (`id`,`exerciseId`,`recordType`,`value`,`date`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PersonalRecord entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getExerciseId());
        if (entity.getRecordType() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getRecordType());
        }
        statement.bindDouble(4, entity.getValue());
        statement.bindLong(5, entity.getDate());
        if (entity.getNotes() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getNotes());
        }
      }
    };
    this.__insertionAdapterOfUserSettings = new EntityInsertionAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_settings` (`id`,`darkTheme`,`autoWeightIncrement`,`defaultRestTime`,`units`,`showPersonalRecords`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSettings entity) {
        statement.bindLong(1, entity.getId());
        final int _tmp = entity.getDarkTheme() ? 1 : 0;
        statement.bindLong(2, _tmp);
        statement.bindDouble(3, entity.getAutoWeightIncrement());
        statement.bindLong(4, entity.getDefaultRestTime());
        if (entity.getUnits() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUnits());
        }
        final int _tmp_1 = entity.getShowPersonalRecords() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
      }
    };
    this.__insertionAdapterOfExerciseLibrary = new EntityInsertionAdapter<ExerciseLibrary>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `exercise_library` (`id`,`name`,`category`,`muscleGroups`,`equipment`,`difficulty`,`instructions`,`isActive`,`isDefault`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ExerciseLibrary entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCategory());
        }
        if (entity.getMuscleGroups() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getMuscleGroups());
        }
        if (entity.getEquipment() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getEquipment());
        }
        if (entity.getDifficulty() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDifficulty());
        }
        if (entity.getInstructions() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getInstructions());
        }
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(8, _tmp);
        final int _tmp_1 = entity.isDefault() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
      }
    };
    this.__deletionAdapterOfExercise = new EntityDeletionOrUpdateAdapter<Exercise>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `exercise` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Exercise entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfUserSettings = new EntityDeletionOrUpdateAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `user_settings` SET `id` = ?,`darkTheme` = ?,`autoWeightIncrement` = ?,`defaultRestTime` = ?,`units` = ?,`showPersonalRecords` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserSettings entity) {
        statement.bindLong(1, entity.getId());
        final int _tmp = entity.getDarkTheme() ? 1 : 0;
        statement.bindLong(2, _tmp);
        statement.bindDouble(3, entity.getAutoWeightIncrement());
        statement.bindLong(4, entity.getDefaultRestTime());
        if (entity.getUnits() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUnits());
        }
        final int _tmp_1 = entity.getShowPersonalRecords() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
        statement.bindLong(7, entity.getId());
      }
    };
    this.__updateAdapterOfExerciseLibrary = new EntityDeletionOrUpdateAdapter<ExerciseLibrary>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `exercise_library` SET `id` = ?,`name` = ?,`category` = ?,`muscleGroups` = ?,`equipment` = ?,`difficulty` = ?,`instructions` = ?,`isActive` = ?,`isDefault` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ExerciseLibrary entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCategory());
        }
        if (entity.getMuscleGroups() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getMuscleGroups());
        }
        if (entity.getEquipment() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getEquipment());
        }
        if (entity.getDifficulty() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDifficulty());
        }
        if (entity.getInstructions() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getInstructions());
        }
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(8, _tmp);
        final int _tmp_1 = entity.isDefault() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
        statement.bindLong(10, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteExerciseById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM exercise WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveDuplicateExercisesByName = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM exercise WHERE workoutTypeId = ? AND name = ? AND id != ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertWorkoutType(final WorkoutType workoutType,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWorkoutType.insert(workoutType);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertExercise(final Exercise exercise,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfExercise.insert(exercise);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertExercises(final List<Exercise> exercises,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfExercise.insert(exercises);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertWorkoutSession(final WorkoutSession session,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfWorkoutSession.insertAndReturnId(session);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSetTracking(final SetTracking setTracking,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSetTracking.insert(setTracking);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertPersonalRecord(final PersonalRecord personalRecord,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPersonalRecord.insert(personalRecord);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertUserSettings(final UserSettings userSettings,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserSettings.insert(userSettings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertExerciseLibrary(final ExerciseLibrary exerciseLibrary,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfExerciseLibrary.insert(exerciseLibrary);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteExercise(final Exercise exercise,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfExercise.handle(exercise);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUserSettings(final UserSettings userSettings,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserSettings.handle(userSettings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateExerciseLibrary(final ExerciseLibrary exerciseLibrary,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfExerciseLibrary.handle(exerciseLibrary);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteExerciseById(final int exerciseId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteExerciseById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, exerciseId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteExerciseById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object removeDuplicateExercisesByName(final int workoutTypeId, final String exerciseName,
      final int keepId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveDuplicateExercisesByName.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, workoutTypeId);
        _argIndex = 2;
        if (exerciseName == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, exerciseName);
        }
        _argIndex = 3;
        _stmt.bindLong(_argIndex, keepId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfRemoveDuplicateExercisesByName.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllWorkoutTypes(final Continuation<? super List<WorkoutType>> $completion) {
    final String _sql = "SELECT * FROM workout_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<WorkoutType>>() {
      @Override
      @NonNull
      public List<WorkoutType> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<WorkoutType> _result = new ArrayList<WorkoutType>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WorkoutType _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item = new WorkoutType(_tmpId,_tmpName,_tmpDescription);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public int getWorkoutTypeCountSync() {
    final String _sql = "SELECT COUNT(*) FROM workout_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getWorkoutTypeCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM workout_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getExercisesByWorkoutType(final int workoutTypeId,
      final Continuation<? super List<Exercise>> $completion) {
    final String _sql = "SELECT * FROM exercise WHERE workoutTypeId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, workoutTypeId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Exercise>>() {
      @Override
      @NonNull
      public List<Exercise> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutTypeId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfRepRange = CursorUtil.getColumnIndexOrThrow(_cursor, "repRange");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<Exercise> _result = new ArrayList<Exercise>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Exercise _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpWorkoutTypeId;
            _tmpWorkoutTypeId = _cursor.getInt(_cursorIndexOfWorkoutTypeId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpRepRange;
            if (_cursor.isNull(_cursorIndexOfRepRange)) {
              _tmpRepRange = null;
            } else {
              _tmpRepRange = _cursor.getString(_cursorIndexOfRepRange);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item = new Exercise(_tmpId,_tmpWorkoutTypeId,_tmpName,_tmpCategory,_tmpRepRange,_tmpDescription);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getLastSession(final int exerciseId,
      final Continuation<? super WorkoutSession> $completion) {
    final String _sql = "SELECT * FROM workout_session WHERE exerciseId = ? ORDER BY date DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<WorkoutSession>() {
      @Override
      @Nullable
      public WorkoutSession call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfSets = CursorUtil.getColumnIndexOrThrow(_cursor, "sets");
          final int _cursorIndexOfReps = CursorUtil.getColumnIndexOrThrow(_cursor, "reps");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final WorkoutSession _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpExerciseId;
            _tmpExerciseId = _cursor.getInt(_cursorIndexOfExerciseId);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final int _tmpSets;
            _tmpSets = _cursor.getInt(_cursorIndexOfSets);
            final int _tmpReps;
            _tmpReps = _cursor.getInt(_cursorIndexOfReps);
            final Double _tmpWeight;
            if (_cursor.isNull(_cursorIndexOfWeight)) {
              _tmpWeight = null;
            } else {
              _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _result = new WorkoutSession(_tmpId,_tmpExerciseId,_tmpDate,_tmpSets,_tmpReps,_tmpWeight,_tmpTime,_tmpNotes);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getLastMetconTime(final int exerciseId,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT time FROM workout_session WHERE exerciseId = ? AND time IS NOT NULL ORDER BY date DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getLong(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<Long> getLastMetconTimeLiveData(final int exerciseId) {
    final String _sql = "SELECT time FROM workout_session WHERE exerciseId = ? AND time IS NOT NULL ORDER BY date DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"workout_session"}, false, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getLong(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getRecentWorkoutSessions(final int exerciseId, final int limit,
      final Continuation<? super List<WorkoutSession>> $completion) {
    final String _sql = "SELECT * FROM workout_session WHERE exerciseId = ? AND weight IS NOT NULL ORDER BY date DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<WorkoutSession>>() {
      @Override
      @NonNull
      public List<WorkoutSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfSets = CursorUtil.getColumnIndexOrThrow(_cursor, "sets");
          final int _cursorIndexOfReps = CursorUtil.getColumnIndexOrThrow(_cursor, "reps");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<WorkoutSession> _result = new ArrayList<WorkoutSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WorkoutSession _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpExerciseId;
            _tmpExerciseId = _cursor.getInt(_cursorIndexOfExerciseId);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final int _tmpSets;
            _tmpSets = _cursor.getInt(_cursorIndexOfSets);
            final int _tmpReps;
            _tmpReps = _cursor.getInt(_cursorIndexOfReps);
            final Double _tmpWeight;
            if (_cursor.isNull(_cursorIndexOfWeight)) {
              _tmpWeight = null;
            } else {
              _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
            }
            final Long _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new WorkoutSession(_tmpId,_tmpExerciseId,_tmpDate,_tmpSets,_tmpReps,_tmpWeight,_tmpTime,_tmpNotes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getRecentSets(final int exerciseId, final int limit,
      final Continuation<? super List<SetTracking>> $completion) {
    final String _sql = "SELECT * FROM set_tracking WHERE exerciseId = ? ORDER BY id DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SetTracking>>() {
      @Override
      @NonNull
      public List<SetTracking> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWorkoutSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutSessionId");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfSetNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "setNumber");
          final int _cursorIndexOfTargetReps = CursorUtil.getColumnIndexOrThrow(_cursor, "targetReps");
          final int _cursorIndexOfActualReps = CursorUtil.getColumnIndexOrThrow(_cursor, "actualReps");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfIsSuccessful = CursorUtil.getColumnIndexOrThrow(_cursor, "isSuccessful");
          final int _cursorIndexOfRpe = CursorUtil.getColumnIndexOrThrow(_cursor, "rpe");
          final List<SetTracking> _result = new ArrayList<SetTracking>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SetTracking _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpWorkoutSessionId;
            _tmpWorkoutSessionId = _cursor.getInt(_cursorIndexOfWorkoutSessionId);
            final int _tmpExerciseId;
            _tmpExerciseId = _cursor.getInt(_cursorIndexOfExerciseId);
            final int _tmpSetNumber;
            _tmpSetNumber = _cursor.getInt(_cursorIndexOfSetNumber);
            final int _tmpTargetReps;
            _tmpTargetReps = _cursor.getInt(_cursorIndexOfTargetReps);
            final int _tmpActualReps;
            _tmpActualReps = _cursor.getInt(_cursorIndexOfActualReps);
            final double _tmpWeight;
            _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
            final boolean _tmpIsSuccessful;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSuccessful);
            _tmpIsSuccessful = _tmp != 0;
            final Double _tmpRpe;
            if (_cursor.isNull(_cursorIndexOfRpe)) {
              _tmpRpe = null;
            } else {
              _tmpRpe = _cursor.getDouble(_cursorIndexOfRpe);
            }
            _item = new SetTracking(_tmpId,_tmpWorkoutSessionId,_tmpExerciseId,_tmpSetNumber,_tmpTargetReps,_tmpActualReps,_tmpWeight,_tmpIsSuccessful,_tmpRpe);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getSetsForSession(final int sessionId,
      final Continuation<? super List<SetTracking>> $completion) {
    final String _sql = "SELECT * FROM set_tracking WHERE workoutSessionId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sessionId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SetTracking>>() {
      @Override
      @NonNull
      public List<SetTracking> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWorkoutSessionId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutSessionId");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfSetNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "setNumber");
          final int _cursorIndexOfTargetReps = CursorUtil.getColumnIndexOrThrow(_cursor, "targetReps");
          final int _cursorIndexOfActualReps = CursorUtil.getColumnIndexOrThrow(_cursor, "actualReps");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
          final int _cursorIndexOfIsSuccessful = CursorUtil.getColumnIndexOrThrow(_cursor, "isSuccessful");
          final int _cursorIndexOfRpe = CursorUtil.getColumnIndexOrThrow(_cursor, "rpe");
          final List<SetTracking> _result = new ArrayList<SetTracking>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SetTracking _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpWorkoutSessionId;
            _tmpWorkoutSessionId = _cursor.getInt(_cursorIndexOfWorkoutSessionId);
            final int _tmpExerciseId;
            _tmpExerciseId = _cursor.getInt(_cursorIndexOfExerciseId);
            final int _tmpSetNumber;
            _tmpSetNumber = _cursor.getInt(_cursorIndexOfSetNumber);
            final int _tmpTargetReps;
            _tmpTargetReps = _cursor.getInt(_cursorIndexOfTargetReps);
            final int _tmpActualReps;
            _tmpActualReps = _cursor.getInt(_cursorIndexOfActualReps);
            final double _tmpWeight;
            _tmpWeight = _cursor.getDouble(_cursorIndexOfWeight);
            final boolean _tmpIsSuccessful;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSuccessful);
            _tmpIsSuccessful = _tmp != 0;
            final Double _tmpRpe;
            if (_cursor.isNull(_cursorIndexOfRpe)) {
              _tmpRpe = null;
            } else {
              _tmpRpe = _cursor.getDouble(_cursorIndexOfRpe);
            }
            _item = new SetTracking(_tmpId,_tmpWorkoutSessionId,_tmpExerciseId,_tmpSetNumber,_tmpTargetReps,_tmpActualReps,_tmpWeight,_tmpIsSuccessful,_tmpRpe);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getLastWeightForExercise(final int exerciseId,
      final Continuation<? super Double> $completion) {
    final String _sql = "SELECT weight FROM workout_session WHERE exerciseId = ? AND weight IS NOT NULL ORDER BY date DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getDouble(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<Double> getLastWeightForExerciseLiveData(final int exerciseId) {
    final String _sql = "SELECT weight FROM workout_session WHERE exerciseId = ? AND weight IS NOT NULL ORDER BY date DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"workout_session"}, false, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getDouble(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getPersonalRecord(final int exerciseId, final String type,
      final Continuation<? super PersonalRecord> $completion) {
    final String _sql = "SELECT * FROM personal_record WHERE exerciseId = ? AND recordType = ? ORDER BY value DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PersonalRecord>() {
      @Override
      @Nullable
      public PersonalRecord call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfRecordType = CursorUtil.getColumnIndexOrThrow(_cursor, "recordType");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final PersonalRecord _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpExerciseId;
            _tmpExerciseId = _cursor.getInt(_cursorIndexOfExerciseId);
            final String _tmpRecordType;
            if (_cursor.isNull(_cursorIndexOfRecordType)) {
              _tmpRecordType = null;
            } else {
              _tmpRecordType = _cursor.getString(_cursorIndexOfRecordType);
            }
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _result = new PersonalRecord(_tmpId,_tmpExerciseId,_tmpRecordType,_tmpValue,_tmpDate,_tmpNotes);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getPersonalRecordHistory(final int exerciseId,
      final Continuation<? super List<PersonalRecord>> $completion) {
    final String _sql = "SELECT * FROM personal_record WHERE exerciseId = ? ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PersonalRecord>>() {
      @Override
      @NonNull
      public List<PersonalRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfRecordType = CursorUtil.getColumnIndexOrThrow(_cursor, "recordType");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<PersonalRecord> _result = new ArrayList<PersonalRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PersonalRecord _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpExerciseId;
            _tmpExerciseId = _cursor.getInt(_cursorIndexOfExerciseId);
            final String _tmpRecordType;
            if (_cursor.isNull(_cursorIndexOfRecordType)) {
              _tmpRecordType = null;
            } else {
              _tmpRecordType = _cursor.getString(_cursorIndexOfRecordType);
            }
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new PersonalRecord(_tmpId,_tmpExerciseId,_tmpRecordType,_tmpValue,_tmpDate,_tmpNotes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserSettings(final Continuation<? super UserSettings> $completion) {
    final String _sql = "SELECT * FROM user_settings LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserSettings>() {
      @Override
      @Nullable
      public UserSettings call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDarkTheme = CursorUtil.getColumnIndexOrThrow(_cursor, "darkTheme");
          final int _cursorIndexOfAutoWeightIncrement = CursorUtil.getColumnIndexOrThrow(_cursor, "autoWeightIncrement");
          final int _cursorIndexOfDefaultRestTime = CursorUtil.getColumnIndexOrThrow(_cursor, "defaultRestTime");
          final int _cursorIndexOfUnits = CursorUtil.getColumnIndexOrThrow(_cursor, "units");
          final int _cursorIndexOfShowPersonalRecords = CursorUtil.getColumnIndexOrThrow(_cursor, "showPersonalRecords");
          final UserSettings _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final boolean _tmpDarkTheme;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDarkTheme);
            _tmpDarkTheme = _tmp != 0;
            final double _tmpAutoWeightIncrement;
            _tmpAutoWeightIncrement = _cursor.getDouble(_cursorIndexOfAutoWeightIncrement);
            final int _tmpDefaultRestTime;
            _tmpDefaultRestTime = _cursor.getInt(_cursorIndexOfDefaultRestTime);
            final String _tmpUnits;
            if (_cursor.isNull(_cursorIndexOfUnits)) {
              _tmpUnits = null;
            } else {
              _tmpUnits = _cursor.getString(_cursorIndexOfUnits);
            }
            final boolean _tmpShowPersonalRecords;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfShowPersonalRecords);
            _tmpShowPersonalRecords = _tmp_1 != 0;
            _result = new UserSettings(_tmpId,_tmpDarkTheme,_tmpAutoWeightIncrement,_tmpDefaultRestTime,_tmpUnits,_tmpShowPersonalRecords);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getExerciseLibraryCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM exercise_library";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getActiveExercisesByCategory(final String category,
      final Continuation<? super List<ExerciseLibrary>> $completion) {
    final String _sql = "SELECT * FROM exercise_library WHERE category = ? AND isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ExerciseLibrary>>() {
      @Override
      @NonNull
      public List<ExerciseLibrary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfMuscleGroups = CursorUtil.getColumnIndexOrThrow(_cursor, "muscleGroups");
          final int _cursorIndexOfEquipment = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfIsDefault = CursorUtil.getColumnIndexOrThrow(_cursor, "isDefault");
          final List<ExerciseLibrary> _result = new ArrayList<ExerciseLibrary>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ExerciseLibrary _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpMuscleGroups;
            if (_cursor.isNull(_cursorIndexOfMuscleGroups)) {
              _tmpMuscleGroups = null;
            } else {
              _tmpMuscleGroups = _cursor.getString(_cursorIndexOfMuscleGroups);
            }
            final String _tmpEquipment;
            if (_cursor.isNull(_cursorIndexOfEquipment)) {
              _tmpEquipment = null;
            } else {
              _tmpEquipment = _cursor.getString(_cursorIndexOfEquipment);
            }
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpInstructions;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmpInstructions = null;
            } else {
              _tmpInstructions = _cursor.getString(_cursorIndexOfInstructions);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final boolean _tmpIsDefault;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDefault);
            _tmpIsDefault = _tmp_1 != 0;
            _item = new ExerciseLibrary(_tmpId,_tmpName,_tmpCategory,_tmpMuscleGroups,_tmpEquipment,_tmpDifficulty,_tmpInstructions,_tmpIsActive,_tmpIsDefault);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllActiveExercises(
      final Continuation<? super List<ExerciseLibrary>> $completion) {
    final String _sql = "SELECT * FROM exercise_library WHERE isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ExerciseLibrary>>() {
      @Override
      @NonNull
      public List<ExerciseLibrary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfMuscleGroups = CursorUtil.getColumnIndexOrThrow(_cursor, "muscleGroups");
          final int _cursorIndexOfEquipment = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment");
          final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
          final int _cursorIndexOfInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "instructions");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfIsDefault = CursorUtil.getColumnIndexOrThrow(_cursor, "isDefault");
          final List<ExerciseLibrary> _result = new ArrayList<ExerciseLibrary>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ExerciseLibrary _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpMuscleGroups;
            if (_cursor.isNull(_cursorIndexOfMuscleGroups)) {
              _tmpMuscleGroups = null;
            } else {
              _tmpMuscleGroups = _cursor.getString(_cursorIndexOfMuscleGroups);
            }
            final String _tmpEquipment;
            if (_cursor.isNull(_cursorIndexOfEquipment)) {
              _tmpEquipment = null;
            } else {
              _tmpEquipment = _cursor.getString(_cursorIndexOfEquipment);
            }
            final String _tmpDifficulty;
            if (_cursor.isNull(_cursorIndexOfDifficulty)) {
              _tmpDifficulty = null;
            } else {
              _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
            }
            final String _tmpInstructions;
            if (_cursor.isNull(_cursorIndexOfInstructions)) {
              _tmpInstructions = null;
            } else {
              _tmpInstructions = _cursor.getString(_cursorIndexOfInstructions);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final boolean _tmpIsDefault;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDefault);
            _tmpIsDefault = _tmp_1 != 0;
            _item = new ExerciseLibrary(_tmpId,_tmpName,_tmpCategory,_tmpMuscleGroups,_tmpEquipment,_tmpDifficulty,_tmpInstructions,_tmpIsActive,_tmpIsDefault);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<Double> getLastSuccessfulWeightLiveData(final int exerciseId) {
    final String _sql = "SELECT weight FROM set_tracking WHERE exerciseId = ? AND isSuccessful = 1 AND weight IS NOT NULL ORDER BY weight DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"set_tracking"}, false, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getDouble(0);
            }
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getRecentPersonalRecords(final int limit,
      final Continuation<? super List<PersonalRecord>> $completion) {
    final String _sql = "SELECT pr.* FROM personal_record pr\n"
            + "    INNER JOIN (\n"
            + "        SELECT exerciseId, MAX(value) as maxValue \n"
            + "        FROM personal_record \n"
            + "        WHERE recordType = 'max_weight'\n"
            + "        GROUP BY exerciseId\n"
            + "    ) latest ON pr.exerciseId = latest.exerciseId AND pr.value = latest.maxValue\n"
            + "    WHERE pr.recordType = 'max_weight'\n"
            + "    ORDER BY pr.date DESC \n"
            + "    LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PersonalRecord>>() {
      @Override
      @NonNull
      public List<PersonalRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfRecordType = CursorUtil.getColumnIndexOrThrow(_cursor, "recordType");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<PersonalRecord> _result = new ArrayList<PersonalRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PersonalRecord _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpExerciseId;
            _tmpExerciseId = _cursor.getInt(_cursorIndexOfExerciseId);
            final String _tmpRecordType;
            if (_cursor.isNull(_cursorIndexOfRecordType)) {
              _tmpRecordType = null;
            } else {
              _tmpRecordType = _cursor.getString(_cursorIndexOfRecordType);
            }
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new PersonalRecord(_tmpId,_tmpExerciseId,_tmpRecordType,_tmpValue,_tmpDate,_tmpNotes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllPersonalRecords(
      final Continuation<? super List<PersonalRecord>> $completion) {
    final String _sql = "SELECT * FROM personal_record ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PersonalRecord>>() {
      @Override
      @NonNull
      public List<PersonalRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
          final int _cursorIndexOfRecordType = CursorUtil.getColumnIndexOrThrow(_cursor, "recordType");
          final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<PersonalRecord> _result = new ArrayList<PersonalRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PersonalRecord _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpExerciseId;
            _tmpExerciseId = _cursor.getInt(_cursorIndexOfExerciseId);
            final String _tmpRecordType;
            if (_cursor.isNull(_cursorIndexOfRecordType)) {
              _tmpRecordType = null;
            } else {
              _tmpRecordType = _cursor.getString(_cursorIndexOfRecordType);
            }
            final double _tmpValue;
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new PersonalRecord(_tmpId,_tmpExerciseId,_tmpRecordType,_tmpValue,_tmpDate,_tmpNotes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getExerciseById(final int exerciseId,
      final Continuation<? super Exercise> $completion) {
    final String _sql = "SELECT * FROM exercise WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, exerciseId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Exercise>() {
      @Override
      @Nullable
      public Exercise call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutTypeId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfRepRange = CursorUtil.getColumnIndexOrThrow(_cursor, "repRange");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final Exercise _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpWorkoutTypeId;
            _tmpWorkoutTypeId = _cursor.getInt(_cursorIndexOfWorkoutTypeId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpRepRange;
            if (_cursor.isNull(_cursorIndexOfRepRange)) {
              _tmpRepRange = null;
            } else {
              _tmpRepRange = _cursor.getString(_cursorIndexOfRepRange);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _result = new Exercise(_tmpId,_tmpWorkoutTypeId,_tmpName,_tmpCategory,_tmpRepRange,_tmpDescription);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getExerciseByName(final int workoutTypeId, final String exerciseName,
      final Continuation<? super Exercise> $completion) {
    final String _sql = "SELECT * FROM exercise WHERE workoutTypeId = ? AND name = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, workoutTypeId);
    _argIndex = 2;
    if (exerciseName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, exerciseName);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Exercise>() {
      @Override
      @Nullable
      public Exercise call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutTypeId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfRepRange = CursorUtil.getColumnIndexOrThrow(_cursor, "repRange");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final Exercise _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpWorkoutTypeId;
            _tmpWorkoutTypeId = _cursor.getInt(_cursorIndexOfWorkoutTypeId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpRepRange;
            if (_cursor.isNull(_cursorIndexOfRepRange)) {
              _tmpRepRange = null;
            } else {
              _tmpRepRange = _cursor.getString(_cursorIndexOfRepRange);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _result = new Exercise(_tmpId,_tmpWorkoutTypeId,_tmpName,_tmpCategory,_tmpRepRange,_tmpDescription);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
