package gln.identifiers

import gln.VertexAttrIndex
import gln.VertexAttrSize
import gln.VertexAttrType
import gln.gl
import gln.vertexArray.GlVertexArraysDsl
import kool.IntBuffer
import kool.adr
import kool.rem
import org.lwjgl.opengl.GL30C
import java.nio.IntBuffer
import java.nio.LongBuffer

fun GlVertexArrays(size: Int) = GlVertexArrays(IntBuffer(size))
inline fun <reified E : Enum<E>> GlVertexArrays(): GlVertexArrays = GlVertexArrays(IntBuffer<E>())

@JvmInline
value class GlVertexArrays(val names: IntBuffer) {
    val rem get() = names.rem
    val adr get() = names.adr

    // --- [ glCreateVertexArrays ] ---

    fun create() = gl.createVertexArrays(this)

    // --- [ glGenVertexArrays ] ---

    fun gen(): GlVertexArrays {
        GL30C.glGenVertexArrays(names)
        return this
    }

    inline fun gen(block: GlVertexArraysDsl.() -> Unit) {
        GL30C.glGenVertexArrays(names)
        GlVertexArraysDsl.names = names
        GlVertexArraysDsl.block()
    }

    fun delete() = GL30C.glDeleteVertexArrays(names)

    operator fun get(index: Int): GlVertexArray = GlVertexArray(names[index])
    operator fun set(index: Int, array: GlVertexArray) {
        names.put(index, array.name)
    }

    operator fun get(enum: Enum<*>): GlVertexArray = GlVertexArray(names[enum.ordinal])
    operator fun set(enum: Enum<*>, array: GlVertexArray) {
        names.put(enum.ordinal, array.name)
    }

    companion object {

        // --- [ glCreateVertexArrays ] ---
        fun create(size: Int) = gl.createVertexArrays(size)
    }
}


@JvmInline
value class GlVertexArray(val name: Int = -1) {

    fun bind() = GL30C.glBindVertexArray(name)
    inline fun bound(block: () -> Unit): GlVertexArray {
        GL30C.glBindVertexArray(name)
        block()
        GL30C.glBindVertexArray(0)
        return this
    }

    fun delete() = GL30C.glDeleteVertexArrays(name)

    // --- [ glDisableVertexArrayAttrib ] ---

    infix fun disableAttrib(index: VertexAttrIndex) = gl.disableVertexArrayAttrib(this, index)

    // --- [ glEnableVertexArrayAttrib ] ---

    infix fun enableAttrib(index: VertexAttrIndex) = gl.enableVertexArrayAttrib(this, index)

    // --- [ glVertexArrayElementBuffer ] ---

    infix fun elementBuffer(buffer: GlBuffer) = gl.vertexArrayElementBuffer(this, buffer)

    // --- [ glVertexArrayVertexBuffer ] ---

    fun vertexBuffer(bindingIndex: Int, buffer: GlBuffer, offset: Int, stride: Int) = gl.vertexArrayVertexBuffer(this, bindingIndex, buffer, offset, stride)

    // --- [ glVertexArrayVertexBuffers ] ---

    fun vertexBuffers(first: Int, buffers: GlBuffers? = null, offsets: LongBuffer? = null, strides: IntBuffer? = null) = gl.vertexArrayVertexBuffers(this, first, buffers, offsets, strides)

    // --- [ glVertexArrayAttribBinding ] ---

    fun attribBinding(attribIndex: VertexAttrIndex, bindingIndex: Int) = gl.vertexArrayAttribBinding(this, attribIndex, bindingIndex)

    // --- [ glVertexArrayAttribFormat ] ---

    fun attribFormat(attribIndex: VertexAttrIndex, size: Int, type: VertexAttrType, normalized: Boolean, relativeOffset: Int) = gl.vertexArrayAttribFormat(this, attribIndex, size, type, normalized, relativeOffset)

    // --- [ glVertexArrayAttribIFormat ] ---

    fun attribIFormat(attribIndex: VertexAttrIndex, size: VertexAttrSize, type: VertexAttrType, relativeOffset: Int) = gl.vertexArrayAttribIFormat(this, attribIndex, size, type, relativeOffset)

    // --- [ glVertexArrayAttribLFormat ] ---

    fun attribLFormat(attribIndex: VertexAttrIndex, size: VertexAttrSize, type: VertexAttrType, relativeOffset: Int) = gl.vertexArrayAttribLFormat(this, attribIndex, size, type, relativeOffset)

    // --- [ glGetVertexArrayiv ] ---

    val elementBuffer: GlBuffer
        get() = gl.getVertexArrayElementBuffer(this)


    companion object {

        // --- [ glCreateVertexArrays ] ---
        fun create(): GlVertexArray = gl.createVertexArrays()

        fun gen(): GlVertexArray = GlVertexArray(GL30C.glGenVertexArrays())
    }
}