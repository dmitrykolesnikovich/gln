package gln.objects

import glm_.bool
import glm_.vec3.Vec3i
import gln.*
import gln.program.ProgramBase
import gln.program.ProgramUse
import kool.adr
import kool.stak
import org.lwjgl.opengl.*
import org.lwjgl.system.MemoryStack.stackGet
import java.lang.Exception

inline class GlProgram(val name: Int) {

    // --- [ glDeleteProgram ] ---

    fun delete() = GL20C.glDeleteProgram(name)

    // --- [ glIsProgram ] ---

    val isValid: Boolean
        get() = GL20C.glIsProgram(name)

    // --- [ glAttachShader ] ---

    infix fun attach(shader: GlShader) = GL20C.glAttachShader(name, shader.name)

    operator fun plusAssign(shader: GlShader) = GL20C.glAttachShader(name, shader.name)

    // --- [ glDetachShader ] ---

    infix fun detach(shader: GlShader) = GL20C.glDetachShader(name, shader.name)

    operator fun minusAssign(shader: GlShader) = GL20C.glDetachShader(name, shader.name)

    // --- [ glShaderSource ] ---

    fun source(source: String) = GL20C.glShaderSource(name, source)

    // --- [ glLinkProgram ] ---

    fun link() = GL20C.glLinkProgram(name)

    // --- [ glUseProgram ] ---

    fun use() = GL20C.glUseProgram(name)

    // JVM custom

    fun unuse() = GL20C.glUseProgram(0)

    inline fun used(block: ProgramUse.() -> Unit) {
        ProgramUse.program = this
        GL20C.glUseProgram(name)
        ProgramUse.block()
        GL20C.glUseProgram(0)
    }

    inline fun use(block: ProgramUse.() -> Unit) {
        ProgramUse.program = this
        GL20C.glUseProgram(name)
        ProgramUse.block()
    }

    // --- [ glValidateProgram ] ---

    fun validate() = GL20C.glValidateProgram(name)

    // --- [ glGetProgramiv ] ---

    val deleteStatus: Boolean
        get() = gl.getProgram(this, GetProgram.DELETE_STATUS)

    val linkStatus: Boolean
        get() = gl.getProgram(this, GetProgram.LINK_STATUS)

    val validateStatus: Boolean
        get() = gl.getProgram(this, GetProgram.VALIDATE_STATUS)

    val infoLogLength: Int
        get() = gl.getProgram(this, GetProgram.INFO_LOG_LENGTH)

    val attachedShadersCount: Int
        get() = gl.getProgram(this, GetProgram.ATTACHED_SHADERS)

    val activeAtomicCounterBuffers: Int
        get() = gl.getProgram(this, GetProgram.ACTIVE_ATOMIC_COUNTER_BUFFERS)

    val activeAttributes: Int
        get() = gl.getProgram(this, GetProgram.ACTIVE_ATTRIBUTES)

    val activeAttributeMaxLength: Int
        get() = gl.getProgram(this, GetProgram.ACTIVE_ATTRIBUTE_MAX_LENGTH)

    val activeUniforms: Int
        get() = gl.getProgram(this, GetProgram.ACTIVE_UNIFORMS)

    val activeUniformMaxLength: Int
        get() = gl.getProgram(this, GetProgram.ACTIVE_UNIFORM_MAX_LENGTH)

    val binaryLength: Int
        get() = gl.getProgram(this, GetProgram.PROGRAM_BINARY_LENGTH)

    val computeWorkGroupSize: Vec3i
        get() = gl.getProgram(this, GetProgram.COMPUTE_WORK_GROUP_SIZE)

    val transformFeedbackBufferMode: Int
        get() = gl.getProgram(this, GetProgram.TRANSFORM_FEEDBACK_BUFFER_MODE)

    val transformFeedbackVaryings: Int
        get() = gl.getProgram(this, GetProgram.TRANSFORM_FEEDBACK_VARYINGS)

    val transformFeedbackVaryingMaxLength: Int
        get() = gl.getProgram(this, GetProgram.TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH)

    val geometryVerticesOut: Int
        get() = gl.getProgram(this, GetProgram.GEOMETRY_VERTICES_OUT)

    val geometryInputType: GeometryInputType
        get() = gl.getProgram(this, GetProgram.GEOMETRY_INPUT_TYPE)

    val geometryOutputType: GeometryOutputType
        get() = gl.getProgram(this, GetProgram.GEOMETRY_OUTPUT_TYPE)

    // --- [ glGetProgramInfoLog ] ---

    val infoLog: String
        get() = gl.getProgramInfoLog(this)

    // --- [ glGetAttachedShaders ] ---

    val attachedShaders: GLshaders
        get() = gl.getAttachedShaders(this)

    // --- [ glGetUniformLocation ] ---

    infix fun getUniformLocation(name: String): Int = gl.getUniformLocation(this, name)
    operator fun get(name: String): Int = gl.getUniformLocation(this, name)

    // --- [ glGetActiveUniform ] ---

    infix fun getActiveUniform(index: Int): Triple<String, Int, UniformType> = gl.getActiveUniform(this, index)

    // --- [ glGetUniform* ] ---

    inline infix fun <reified T> getUniform(location: Int): T =  gl.getUniform(this, location)

    // --- [ glGetAttribLocation ] ---
    infix fun getAttribLocation(name: String): Int = GL20.glGetAttribLocation(this.name, name)

    // --- [ glBindAttribLocation ] ---

    fun bindAttribLocation(index: Int, name: String) {
        val stack = stackGet()
        val ptr = stack.pointer
        GL20C.nglBindAttribLocation(this.name, index, stack.ASCII(name).adr)
        stack.pointer = ptr
    }

    // --- [ glGetUniformBlockIndex ] ---
    fun getUniformBlockIndex(uniformBlockName: CharSequence) = GL31C.glGetUniformBlockIndex(name, uniformBlockName)

    // --- [ glUniformBlockBinding ] ---
    fun uniformBlockBinding(uniformBlockIndex: Int, uniformBlockBinding: Int) = GL31C.glUniformBlockBinding(name, uniformBlockIndex, uniformBlockBinding)

    fun uniformBlockBinding(uniformBlockIndex: Int, uniformBlockBinding: Enum<*>) = GL31C.glUniformBlockBinding(name, uniformBlockIndex, uniformBlockBinding.ordinal)

    // --- [ glBindFragDataLocation ] ---

    fun bindFragDataLocation(index: Int, name: String) {
        val stack = stackGet()
        val ptr = stack.pointer
        GL20C.nglBindAttribLocation(this.name, index, stack.ASCII(name).adr)
        stack.pointer = ptr
    }

    // --- [ glGetActiveAttrib ] ---

    fun getActiveAttrib(index: Int): Triple<String, Int, AttributeType> = gl.getActiveAttrib(this, index)

    companion object {

        val NULL = GlProgram(-1)

        // --- [ glCreateProgram ] ---
        fun create() = GlProgram(GL20C.glCreateProgram())

        inline fun init(block: ProgramBase.() -> Unit): GlProgram {
            ProgramBase.program = create()
            ProgramBase.block()
            return ProgramBase.program
        }

        /** for ogl-samples */
        inline fun initFromPath(vert: String, frag: String, block: ProgramBase.() -> Unit): GlProgram =
                init(GlShader.createFromPath(vert), GlShader.createFromPath(frag), block)

        inline fun init(vert: GlShader, frag: GlShader, block: ProgramBase.() -> Unit): GlProgram {
            ProgramBase.apply {
                program = create().apply {
                    plusAssign(vert)
                    plusAssign(frag)
                }

                block()

                program.apply {
                    link()

                    if (!linkStatus)
                        throw Exception("Linker failure: $infoLog")

                    minusAssign(vert)
                    minusAssign(frag)
                    vert.delete()
                    frag.delete()
                }
            }
            return ProgramBase.program
        }

        fun createFromSource(vertSrc: String, fragSrc: String): GlProgram {

            val program = GlProgram.create()

            val v = GlShader.createFromSource(ShaderType.VERTEX_SHADER, vertSrc)
            val f = GlShader.createFromSource(ShaderType.FRAGMENT_SHADER, fragSrc)

            program += v
            program += f

            program.link()


            program -= v
            program -= f
            v.delete()
            f.delete()

            if (!program.linkStatus) throw Exception("Linker failure: ${program.infoLog}")

            return program
        }

        fun createFromSource(vertSrc: String, geomSrc: String, fragSrc: String): GlProgram {

            val program = GlProgram.create()

            val v = GlShader.createFromSource(ShaderType.VERTEX_SHADER, vertSrc)
            val g = GlShader.createFromSource(ShaderType.GEOMETRY_SHADER, geomSrc)
            val f = GlShader.createFromSource(ShaderType.FRAGMENT_SHADER, fragSrc)

            program += v
            program += g
            program += f

            program.link()


            program -= v
            program -= g
            program -= f
            v.delete()
            g.delete()
            f.delete()

            if (!program.linkStatus) throw Exception("Linker failure: ${program.infoLog}")

            return program
        }

        // TODO createFromPath
    }
}