/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package titik;
import java.util.logging.Level;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_POINTS;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glPointSize;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.util.glu.GLU.gluOrtho2D;


public class titik {
    public static int DISPLAY_WIDTH =800;
    public static int DISPLAY_HEIGHT=600;

    public void render() {
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();
        glColor3f(0.0f, 1.0f, 1.0f);
        glPointSize(10);
        glBegin(GL_POINTS);
        glVertex2f(100, 100);
        glVertex2f(200, 100);
        glVertex2f(200, 300);
        glVertex2f(100, 300);
        glVertex2f(150, 375);
        glVertex2f(375, 375);
        glVertex2f(425, 300);
        glVertex2f(425, 100);
        glVertex2f(425, 300);
        glVertex2f(525, 300);
        glEnd();
        }
    public static void main(String[] args) {
        titik main = null;
            try {
            System.out.println("Keys:");
            System.out.println("esc - Exit");
            main = new titik();
            main.create();
            main.run();
            } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            } finally {
            if (main != null) {
            main.destroy();
            }
            
    }
    
}
    private void create() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(DISPLAY_WIDTH,DISPLAY_HEIGHT));
        Display.setDisplayMode(new DisplayMode(DISPLAY_WIDTH,DISPLAY_HEIGHT));
        Display.setFullscreen(false);
        Display.setTitle("Create Point");
        Display.create();
        //Keyboard
         Keyboard.create();
        //Mouse
        Mouse.setGrabbed(false);
        Mouse.create();
        //OpenGL
        initGL();
        resizeGL(); //To change body of generated methods, choose Tools | Templates.
        }

    private void run() {
         while (!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !Display.isCloseRequested()) {
     if (Display.isVisible()) {
    render();
    } else {
    if (Display.isDirty()) {
    render();
    }
    try {
    Thread.sleep(100);
    } catch (InterruptedException ex) {
        }
    }
    Display.update();
    Display.sync(60);
    }
    }

    
    private void destroy() {
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    private void initGL() {
         //2D Initialization
    glClearColor(0.5f, 0.5f, 0.5f, 0.0f);
    glDisable(GL_DEPTH_TEST);
    glDisable(GL_LIGHTING);
    }

    private void resizeGL() {
        //2D Scene
    glViewport(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0.0f, DISPLAY_WIDTH, 0.0f, DISPLAY_HEIGHT);
    glPushMatrix();
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glPushMatrix();
    }
}
