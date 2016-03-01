package ru.egslava.tutorialglsurfaceview

import android.opengl.GLES20.GL_COLOR_BUFFER_BIT
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        glSurface.setRenderer(TutorialRenderer())
    }

    class TutorialRenderer : GLSurfaceView.Renderer {
        var color = 0f
        var colorVelocity = 1f/60f

        override fun onDrawFrame(gl: GL10){
            if (color > 1 || color < 0){
                colorVelocity = -colorVelocity
            }
            color += colorVelocity

            gl.glClearColor(color * 0.5f, color, color, 1f)
            gl.glClear(GL_COLOR_BUFFER_BIT)
        }

        override fun onSurfaceCreated(gl: GL10, config: EGLConfig){}
        override fun onSurfaceChanged(gl: GL10, width: Int, height: Int){}
    }
}
