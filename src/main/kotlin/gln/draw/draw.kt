@file:Suppress("NOTHING_TO_INLINE")

package gln.draw

import glm_.BYTES
import glm_.L
import gln.DataType
import gln.draw.DrawMode.Companion.TRIANGLES
import kool.BYTES
import kool.rem
import org.lwjgl.opengl.*
import org.lwjgl.opengl.GL32.*
import org.lwjgl.opengl.GL40.GL_PATCHES
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.ShortBuffer


@JvmInline
value class DrawMode(val i: Int) {
    companion object {
        val POINTS = DrawMode(GL_POINTS)
        val LINE_STRIP = DrawMode(GL_LINE_STRIP)
        val LINE_LOOP = DrawMode(GL_LINE_LOOP)
        val LINES = DrawMode(GL_LINES)
        val LINE_STRIP_ADJACENCY = DrawMode(GL_LINE_STRIP_ADJACENCY)
        val LINES_ADJACENCY = DrawMode(GL_LINES_ADJACENCY)
        val TRIANGLE_STRIP = DrawMode(GL_TRIANGLE_STRIP)
        val TRIANGLE_FAN = DrawMode(GL_TRIANGLE_FAN)
        val TRIANGLES = DrawMode(GL_TRIANGLES)
        val TRIANGLE_STRIP_ADJACENCY = DrawMode(GL_TRIANGLE_STRIP_ADJACENCY)
        val TRIANGLES_ADJACENCY = DrawMode(GL_TRIANGLES_ADJACENCY)
        val PATCHES = DrawMode(GL_PATCHES)
    }
}

inline fun glDrawArrays(count: Int) = GL11C.glDrawArrays(GL11C.GL_TRIANGLES, 0, count)
inline fun glDrawArrays(mode: DrawMode, count: Int) = GL11C.glDrawArrays(mode.i, 0, count)

inline fun glMultiDrawArrays(first: IntArray, count: IntArray) = GL14.glMultiDrawArrays(GL11C.GL_TRIANGLES, first, count)
inline fun glMultiDrawArrays(first: IntBuffer, count: IntBuffer) = GL14.glMultiDrawArrays(GL11C.GL_TRIANGLES, first, count)

inline fun glDrawArraysInstanced(count: Int, primCount: Int) = glDrawArraysInstanced(TRIANGLES, count, primCount)
inline fun glDrawArraysInstanced(mode: DrawMode, count: Int, primCount: Int) = GL31.glDrawArraysInstanced(mode.i, 0, count, primCount)

inline fun glDrawArraysIndirect(indirect: Long) = GL40.glDrawArraysIndirect(GL11C.GL_TRIANGLES, indirect)
inline fun glDrawArraysIndirect(indirect: IntArray) = GL40.glDrawArraysIndirect(GL11C.GL_TRIANGLES, indirect)
inline fun glDrawArraysIndirect(indirect: IntBuffer) = GL40.glDrawArraysIndirect(GL11C.GL_TRIANGLES, indirect)
inline fun glDrawArraysIndirect(indirect: ByteBuffer) = GL40.glDrawArraysIndirect(GL11C.GL_TRIANGLES, indirect)

inline fun glDrawArraysInstancedBaseInstance(count: Int, primCount: Int, baseInstance: Int) = glDrawArraysInstancedBaseInstance(GL11C.GL_TRIANGLES, count, primCount, baseInstance)
inline fun glDrawArraysInstancedBaseInstance(mode: Int, count: Int, primCount: Int, baseInstance: Int) = GL42.glDrawArraysInstancedBaseInstance(mode, 0, count, primCount, baseInstance)
// TODO check primcount, also stride: Int = 0
inline fun glMultiDrawArraysIndirect(indirect: ByteBuffer) = GL43.glMultiDrawArraysIndirect(GL11C.GL_TRIANGLES, indirect, indirect.rem / DrawArraysIndirectCommand_SIZE, 0)
inline fun glMultiDrawArraysIndirect(mode: DrawMode, indirect: ByteBuffer) = GL43.glMultiDrawArraysIndirect(mode.i, indirect, indirect.rem / DrawArraysIndirectCommand_SIZE, 0)
inline fun glMultiDrawArraysIndirect(mode: DrawMode, indirect: ByteBuffer, primCount: Int) = GL43.glMultiDrawArraysIndirect(mode.i, indirect, primCount, 0)
inline fun glMultiDrawArraysIndirect(indirect: IntBuffer) = GL43.glMultiDrawArraysIndirect(GL11C.GL_TRIANGLES, indirect, indirect.rem / DrawArraysIndirectCommand_LENGTH, 0)
inline fun glMultiDrawArraysIndirect(mode: DrawMode, indirect: IntBuffer) = GL43.glMultiDrawArraysIndirect(mode.i, indirect, indirect.rem / DrawArraysIndirectCommand_LENGTH, 0)
inline fun glMultiDrawArraysIndirect(mode: DrawMode, indirect: IntBuffer, primCount: Int) = GL43.glMultiDrawArraysIndirect(mode.i, indirect, primCount, 0)
inline fun glMultiDrawArraysIndirect(indirect: IntArray) = GL43.glMultiDrawArraysIndirect(GL11C.GL_TRIANGLES, indirect, indirect.size / DrawArraysIndirectCommand_LENGTH, 0)
inline fun glMultiDrawArraysIndirect(mode: DrawMode, indirect: IntArray) = GL43.glMultiDrawArraysIndirect(mode.i, indirect, indirect.size / DrawArraysIndirectCommand_LENGTH, 0)
inline fun glMultiDrawArraysIndirect(mode: DrawMode, indirect: IntArray, primCount: Int) = GL43.glMultiDrawArraysIndirect(mode.i, indirect, primCount, 0)

inline fun glMultiDrawArraysIndirectBindlessNV(indirect: ByteBuffer, drawCount: Int, vertexBufferCount: Int) = glMultiDrawArraysIndirectBindlessNV(TRIANGLES, indirect, drawCount, vertexBufferCount)
inline fun glMultiDrawArraysIndirectBindlessNV(mode: DrawMode, indirect: ByteBuffer, drawCount: Int, vertexBufferCount: Int) = NVBindlessMultiDrawIndirect.glMultiDrawArraysIndirectBindlessNV(mode.i, indirect, drawCount, 0, vertexBufferCount)

inline fun glMultiDrawArraysIndirectBindlessCountNV(indirect: ByteBuffer, drawCount: Long, maxDrawCount: Int, vertexBufferCount: Int) = glMultiDrawArraysIndirectBindlessCountNV(TRIANGLES, indirect, drawCount, maxDrawCount, vertexBufferCount)
inline fun glMultiDrawArraysIndirectBindlessCountNV(mode: DrawMode, indirect: ByteBuffer, drawCount: Long, maxDrawCount: Int, vertexBufferCount: Int) = NVBindlessMultiDrawIndirectCount.glMultiDrawArraysIndirectBindlessCountNV(mode.i, indirect, drawCount, maxDrawCount, 0, vertexBufferCount)

inline fun glDrawElements(count: Int, indices: Int = 0) = GL11C.glDrawElements(GL11C.GL_TRIANGLES, count, GL11C.GL_UNSIGNED_INT, indices.L)
inline fun glDrawElements(count: Int, type: DataType, indices: Int = 0) = GL11C.glDrawElements(GL11C.GL_TRIANGLES, count, type.i, indices.L)
inline fun glDrawElements(mode: DrawMode, count: Int, type: DataType, indices: Int = 0) = GL11C.glDrawElements(mode.i, count, type.i, indices.L)

// automatic
inline fun glDrawElements(ints: IntBuffer, indices: Int = 0) = GL11C.glDrawElements(GL11C.GL_TRIANGLES, ints.rem, GL11C.GL_UNSIGNED_INT, indices.L)
inline fun glDrawElements(shorts: ShortBuffer, indices: Int = 0) = GL11C.glDrawElements(GL11C.GL_TRIANGLES, shorts.rem, GL11C.GL_UNSIGNED_SHORT, indices.L)

inline fun glDrawElementsBaseVertex(count: Int, type: DataType, indices_buffer_offset: Long, basevertex: Int) = GL32.glDrawElementsBaseVertex(GL11C.GL_TRIANGLES, count, type.i, indices_buffer_offset, basevertex)
// TODO finish
inline fun glDrawElementsInstancedBaseVertex(count: Int, type: DataType, primcount: Int, basevertex: Int) = GL32.glDrawElementsInstancedBaseVertex(GL11C.GL_TRIANGLES, count, type.i, 0, primcount, basevertex)


/**
 *     typedef  struct {
 *          uint  count;
 *          uint  instanceCount;
 *          uint  first;
 *          uint  baseInstance;
 *     } DrawArraysIndirectCommand;
 */
val DrawArraysIndirectCommand_LENGTH = 4 // TODO property of inline classe
val DrawArraysIndirectCommand_SIZE = DrawArraysIndirectCommand_LENGTH * Int.BYTES // TODO property of inline classe