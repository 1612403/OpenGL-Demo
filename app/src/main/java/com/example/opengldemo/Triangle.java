package com.example.opengldemo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class Triangle {

    private FloatBuffer mFVertexBuffer;
    private ByteBuffer mIndexBuffer;
    private FloatBuffer mColorBuffer;

    public Triangle() {

        float vertices[] = {
                -1.0f, -0.5f, -20f,
                1.0f, -0.5f, -20f,
                0f, 1.0f, -20f
        };

        byte indices[] = { 0, 1, 2 };

        float colors[] = {
                1, 0, 0, 1,
                0, 1, 0, 1,
                0, 0, 1, 1
        };

        mFVertexBuffer = makeFloatBuffer(vertices);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);

        mColorBuffer = makeFloatBuffer(colors);
    }

    public void draw(GL10 gl) {
        gl.glVertexPointer(3, GL11.GL_FLOAT, 0, mFVertexBuffer);
        gl.glColorPointer(4, GL11.GL_FLOAT, 0, mColorBuffer);
        gl.glDrawElements(GL11.GL_TRIANGLES, 3, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);
    }

    private static FloatBuffer makeFloatBuffer(float[] arr) {
        ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(arr);
        fb.position(0);
        return fb;
    }
}
