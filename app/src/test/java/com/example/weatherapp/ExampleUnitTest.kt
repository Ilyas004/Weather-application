package com.example.weatherapp

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @ExperimentalCoroutinesApi
    @RunWith(MockitoJUnitRunner::class)
    class DefaultLocationTrackerTest {

        @Mock
        private lateinit var locationClient: FusedLocationProviderClient

        @Mock
        private lateinit var application: Application

        @Mock
        private lateinit var locationManager: LocationManager

        private lateinit var defaultLocationTracker: DefaultLocationTracker

        @Before
        fun setup() {
            MockitoAnnotations.openMocks(this)
            defaultLocationTracker = DefaultLocationTracker(locationClient, application)

            // Мокирование методов и разрешений, связанных с местоположением
            mockkStatic(ContextCompat::class)
            `when`(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_FINE_LOCATION))
                .thenReturn(PackageManager.PERMISSION_GRANTED)
            `when`(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_COARSE_LOCATION))
                .thenReturn(PackageManager.PERMISSION_GRANTED)

            mockkStatic(LocationManager::class)
            `when`(application.getSystemService(Context.LOCATION_SERVICE)).thenReturn(locationManager)
            `when`(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)).thenReturn(true)
            `when`(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)).thenReturn(true)
        }

        @After
        fun teardown() {
            unmockkAll()
        }

        @Test
        fun getCurrentLocation_LocationPermissionsGranted_ReturnsLocation() = runBlocking {
            // Arrange
            val location = mockk<Location>()
            val task = mockk<Task<Location>>()
            every { locationClient.lastLocation } returns task
            every { task.isComplete } returns true
            every { task.isSuccessful } returns true
            every { task.result } returns location

            // Act
            val result = defaultLocationTracker.getCurrentLocation()

            // Assert
            assert(result == location)
        }

        @Test
        fun getCurrentLocation_LocationPermissionsDenied_ReturnsNull() = runBlocking {
            // Arrange
            `when`(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_FINE_LOCATION))
                .thenReturn(PackageManager.PERMISSION_DENIED)

            // Act
            val result = defaultLocationTracker.getCurrentLocation()

            // Assert
            assert(result == null)
        }

        @Test
        fun getCurrentLocation_LocationProvidersDisabled_ReturnsNull() = runBlocking {
            // Arrange
            `when`(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)).thenReturn(false)
            `when`(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)).thenReturn(false)

            // Act
            val result = defaultLocationTracker.getCurrentLocation()

            // Assert
            assert(result == null)
        }
    }
}