package com.cookandroid.wildlift

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.wildlift.champion.ChampionFactory
import com.cookandroid.wildlift.spell.SpellFactory
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallState
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.ActivityResult
import com.google.android.play.core.install.model.ActivityResult.RESULT_IN_APP_UPDATE_FAILED
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.AppUpdateType.IMMEDIATE
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability

class SplashActivity : AppCompatActivity(), InstallStateUpdatedListener {

    private val appUpdateManager by lazy {
        AppUpdateManagerFactory.create(this)
    }
    private val MY_REQUEST_CODE = 100
    private val splashTime:Long = 2000

    var championList = ChampionFactory.championList
    var spellList = SpellFactory.spellList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
// 2초 지나고 화면 전환
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },splashTime)
        //getInAppUpdateWithPlayStore()
    }

    // 업데이트를 체크하는데 사용하는 객체 반환
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MY_REQUEST_CODE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    popupSnackbarForState("App is uploading", Snackbar.LENGTH_INDEFINITE)
                }
                Activity.RESULT_CANCELED -> {
                    popupSnackbarForState("You cancel for update new version.", Snackbar.LENGTH_SHORT)
                }
               RESULT_IN_APP_UPDATE_FAILED -> {
                    popupSnackbarForState("App download failed.", Snackbar.LENGTH_SHORT)
                }
            }
        }
    }

    override fun onStateUpdate(state: InstallState) {
        if (state.installStatus() == InstallStatus.DOWNLOADED) {
            popupSnackbarForCompleteUpdate()
        } else if (state.installStatus() == InstallStatus.INSTALLED) {
            popupSnackbarForState("An update has just been downloaded.", Snackbar.LENGTH_LONG)
            appUpdateManager.unregisterListener(this)
        }
    }


    // 업데이트 유형에 따른 업데이트 제안
    private fun getInAppUpdateWithPlayStore() {
        /*
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE && appUpdateInfo.isUpdateTypeAllowed(
                    AppUpdateType.IMMEDIATE)) {
                try {
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        AppUpdateType.IMMEDIATE, // 유연한 업데이트 사용 시 (AppUpdateType.FLEXIBLE) 사용
                        this,  // 현재 Activity
                        MY_REQUEST_CODE) // 전역변수로 선언해준 Code
                } catch (e: IntentSender.SendIntentException) {
                    Log.e("AppUpdater", "AppUpdateManager Error", e)
                    e.printStackTrace()
                }
            }
            // 업데이트 없음
            else {
                // 2초 지나고 화면 전환
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                },splashTime)

            }
        }

         */
    }

    /*
    //업데이트 중 취소나 닫으면 백그라운드에서 업데이트 계속하여 실행
    override fun onResume() {
        super.onResume()

        appUpdateManager
            .appUpdateInfo
            .addOnSuccessListener { appUpdateInfo ->
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                    // 계속해서 업데이트 진행
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        IMMEDIATE,
                        this,
                        MY_REQUEST_CODE
                    );
                }
            }
    }

     */
/*
    override fun onDestroy() {

        super.onDestroy()
        appUpdateManager.unregisterListener(this)
    }

 */

    private fun popupSnackbarForState(text: String, length: Int) {
        /*
        Snackbar.make(
            findViewById(R.id.cstLyMain),
            text,
            length
        ).show()

         */
    }

    private fun popupSnackbarForCompleteUpdate() {
        /*
        Snackbar.make(
            findViewById(R.id.cstLyMain),
            "An update has just been downloaded from Play Store.",
            Snackbar.LENGTH_INDEFINITE
        ).apply {
            setAction("RESTART") {
                appUpdateManager.completeUpdate()
                appUpdateManager.unregisterListener(this@SplashActivity)
            }
            show()
        }
        */

    }

}