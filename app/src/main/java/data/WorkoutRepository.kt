import com.example.workouttracker.data.WorkoutDao
import com.example.workouttracker.data.WorkoutEntry
import kotlinx.coroutines.flow.Flow


class WorkoutRepository(private val workoutDao: WorkoutDao) {

    val allWorkouts: Flow<List<WorkoutEntry>> = workoutDao.getAllWorkouts()

    suspend fun insert(workout: WorkoutEntry) {
        workoutDao.insertWorkout(workout)
    }
}

