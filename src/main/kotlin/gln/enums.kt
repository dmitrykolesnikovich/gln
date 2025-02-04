package gln

import glm_.BYTES
import glm_.vec2.Vec2b
import glm_.vec3.Vec3b
import glm_.vec4.Vec4b
import kool.BYTES
import org.lwjgl.opengl.*

/*  This is the OpenGL and OpenGL ES enumerant registry.
    https://opensource.apple.com/source/X11server/X11server-85/libGL/AppleSGLX-57/specs/enum.spec
 */

@JvmInline
value class AttribMask(val i: Int) {

    companion object {
        val DEPTH_BUFFER_BIT = AttribMask(GL11.GL_DEPTH_BUFFER_BIT)
        val STENCIL_BUFFER_BIT = AttribMask(GL11.GL_STENCIL_BUFFER_BIT)
        val COLOR_BUFFER_BIT = AttribMask(GL11.GL_COLOR_BUFFER_BIT)
    }

    infix fun and(other: AttribMask): AttribMask = AttribMask(i and other.i)
    infix fun or(other: AttribMask): AttribMask = AttribMask(i or other.i)
    fun inv() = AttribMask(i.inv())
}

@JvmInline
value class ClearBufferMask(val i: Int) {

    companion object {
        val COLOR_BUFFER_BIT = ClearBufferMask(GL11.GL_COLOR_BUFFER_BIT)
        val STENCIL_BUFFER_BIT = ClearBufferMask(GL11.GL_STENCIL_BUFFER_BIT)
        val DEPTH_BUFFER_BIT = ClearBufferMask(GL11.GL_DEPTH_BUFFER_BIT)
        val COLOR_STENCIL_BUFFER_BIT = ClearBufferMask(GL11.GL_COLOR_BUFFER_BIT or GL11.GL_STENCIL_BUFFER_BIT)
        val COLOR_DEPTH_BUFFER_BIT = ClearBufferMask(GL11.GL_COLOR_BUFFER_BIT or GL11.GL_DEPTH_BUFFER_BIT)
        val DEPTH_STENCIL_BUFFER_BIT = ClearBufferMask(GL11.GL_DEPTH_BUFFER_BIT or GL11.GL_STENCIL_BUFFER_BIT)
    }

    infix fun and(other: ClearBufferMask): ClearBufferMask = ClearBufferMask(i and other.i)
    infix fun or(other: ClearBufferMask): ClearBufferMask = ClearBufferMask(i or other.i)
    fun inv() = ClearBufferMask(i.inv())
}

//###############################################################################
//
//ClientAttribMask enum:
//CLIENT_PIXEL_STORE_BIT				= 0x00000001
//CLIENT_VERTEX_ARRAY_BIT				= 0x00000002
//CLIENT_ALL_ATTRIB_BITS				= 0xFFFFFFFF
//
//###############################################################################
//
//# There's no obvious better place to put non-attribute-group mask bits
//# VERSION_3_0 enum:
//# ARB_map_buffer_range enum:
//#	MAP_READ_BIT					= 0x0001	# 3.0 / ARB_mbr
//#	MAP_WRITE_BIT					= 0x0002	# 3.0 / ARB_mbr
//#	MAP_INVALIDATE_RANGE_BIT			= 0x0004	# 3.0 / ARB_mbr
//#	MAP_INVALIDATE_BUFFER_BIT			= 0x0008	# 3.0 / ARB_mbr
//#	MAP_FLUSH_EXPLICIT_BIT				= 0x0010	# 3.0 / ARB_mbr
//#	MAP_UNSYNCHRONIZED_BIT				= 0x0020	# 3.0 / ARB_mbr
//
//###############################################################################
//
//# VERSION_3_0 enum:
//#	CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT		= 0x0001	# 3.0
//
//###############################################################################
//
//Boolean enum:
//FALSE						= 0
//TRUE						= 1
//
//###############################################################################

@JvmInline
value class DrawMode(val i: Int) {

    companion object {
        val POINTS = DrawMode(GL11.GL_POINTS)
        val LINES = DrawMode(GL11.GL_LINES)
        val LINE_LOOP = DrawMode(GL11.GL_LINE_LOOP)
        val LINE_STRIP = DrawMode(GL11.GL_LINE_STRIP)
        val TRIANGLES = DrawMode(GL11.GL_TRIANGLES)
        val TRIANGLE_STRIP = DrawMode(GL11.GL_TRIANGLE_STRIP)
        val TRIANGLE_FAN = DrawMode(GL11.GL_TRIANGLE_FAN)
        val LINES_ADJACENCY = DrawMode(GL32.GL_LINES_ADJACENCY)
        val LINE_STRIP_ADJACENCY = DrawMode(GL32.GL_LINE_STRIP_ADJACENCY)
        val TRIANGLES_ADJACENCY = DrawMode(GL32.GL_TRIANGLES_ADJACENCY)
        val TRIANGLE_STRIP_ADJACENCY = DrawMode(GL32.GL_TRIANGLE_STRIP_ADJACENCY)
        val PATCHES = DrawMode(GL40.GL_PATCHES)
    }
}

//###############################################################################
//
//AccumOp enum:
//ACCUM						= 0x0100
//LOAD						= 0x0101
//RETURN						= 0x0102
//MULT						= 0x0103
//ADD						= 0x0104
//
//###############################################################################
//
//AlphaFunction enum:
//NEVER						= 0x0200
//LESS						= 0x0201
//EQUAL						= 0x0202
//LEQUAL						= 0x0203
//GREATER						= 0x0204
//NOTEQUAL					= 0x0205
//GEQUAL						= 0x0206
//ALWAYS						= 0x0207
//
//###############################################################################

@JvmInline
value class BlendFactor(val i: Int) {

    companion object {
        val ZERO = BlendFactor(GL11.GL_ZERO)
        val ONE = BlendFactor(GL11.GL_ONE)
        val SRC_COLOR = BlendFactor(GL11.GL_SRC_COLOR)
        val ONE_MINUS_SRC_COLOR = BlendFactor(GL11.GL_ONE_MINUS_SRC_COLOR)
        val DST_COLOR = BlendFactor(GL11.GL_DST_COLOR)
        val ONE_MINUS_DST_COLOR = BlendFactor(GL11.GL_ONE_MINUS_DST_COLOR)
        val SRC_ALPHA = BlendFactor(GL11.GL_SRC_ALPHA)
        val ONE_MINUS_SRC_ALPHA = BlendFactor(GL11.GL_ONE_MINUS_SRC_ALPHA)
        val DST_ALPHA = BlendFactor(GL11.GL_DST_ALPHA)
        val ONE_MINUS_DST_ALPHA = BlendFactor(GL11.GL_ONE_MINUS_DST_ALPHA)
        val CONSTANT_COLOR = BlendFactor(GL14.GL_CONSTANT_COLOR)
        val ONE_MINUS_CONSTANT_COLOR = BlendFactor(GL14.GL_ONE_MINUS_CONSTANT_COLOR)
        val CONSTANT_ALPHA = BlendFactor(GL14.GL_CONSTANT_ALPHA)
        val ONE_MINUS_CONSTANT_ALPHA = BlendFactor(GL14.GL_ONE_MINUS_CONSTANT_ALPHA)
        val SRC_ALPHA_SATURATE = BlendFactor(GL14.GL_SRC_ALPHA_SATURATE)
        val SRC1_COLOR = BlendFactor(GL33.GL_SRC1_COLOR)
        val ONE_MINUS_SRC1_COLOR = BlendFactor(GL33.GL_ONE_MINUS_SRC1_COLOR)
        val SRC1_ALPHA = BlendFactor(GL15.GL_SRC1_ALPHA)
        val ONE_MINUS_SRC1_ALPHA = BlendFactor(GL33.GL_ONE_MINUS_SRC1_ALPHA)
    }
}

//###############################################################################

@JvmInline
value class BlendEquationMode(val i: Int) {

    companion object {
        val FUNC_ADD = BlendEquationMode(GL14.GL_FUNC_ADD)
        val MIN = BlendEquationMode(GL14.GL_MIN)
        val MAX = BlendEquationMode(GL14.GL_MAX)
        val FUNC_SUBTRACT = BlendEquationMode(GL14.GL_FUNC_SUBTRACT)
        val FUNC_REVERSE_SUBTRACT = BlendEquationMode(GL14.GL_FUNC_REVERSE_SUBTRACT)
    }
}

//##############################################################################
//
//ColorMaterialFace enum:
//use DrawBufferMode FRONT
//use DrawBufferMode BACK
//use DrawBufferMode FRONT_AND_BACK
//
//###############################################################################
//
//ColorMaterialParameter enum:
//use LightParameter AMBIENT
//use LightParameter DIFFUSE
//use LightParameter SPECULAR
//use MaterialParameter EMISSION
//use MaterialParameter AMBIENT_AND_DIFFUSE
//
//###############################################################################
//
//ColorPointerType enum:
//use DataType BYTE
//use DataType UNSIGNED_BYTE
//use DataType SHORT
//use DataType UNSIGNED_SHORT
//use DataType INT
//use DataType UNSIGNED_INT
//use DataType FLOAT
//use DataType DOUBLE
//
//###############################################################################
//
//ColorTableParameterPNameSGI enum:
//use SGI_color_table COLOR_TABLE_SCALE_SGI
//use SGI_color_table COLOR_TABLE_BIAS_SGI
//
//###############################################################################
//
//ColorTableTargetSGI enum:
//use SGI_color_table COLOR_TABLE_SGI
//use SGI_color_table POST_CONVOLUTION_COLOR_TABLE_SGI
//use SGI_color_table POST_COLOR_MATRIX_COLOR_TABLE_SGI
//use SGI_color_table PROXY_COLOR_TABLE_SGI
//use SGI_color_table PROXY_POST_CONVOLUTION_COLOR_TABLE_SGI
//use SGI_color_table PROXY_POST_COLOR_MATRIX_COLOR_TABLE_SGI
//use SGI_texture_color_table TEXTURE_COLOR_TABLE_SGI
//use SGI_texture_color_table PROXY_TEXTURE_COLOR_TABLE_SGI
//
//###############################################################################
//
//ConvolutionBorderModeEXT enum:
//use EXT_convolution REDUCE_EXT
//
//###############################################################################
//
//ConvolutionParameterEXT enum:
//use EXT_convolution CONVOLUTION_BORDER_MODE_EXT
//use EXT_convolution CONVOLUTION_FILTER_SCALE_EXT
//use EXT_convolution CONVOLUTION_FILTER_BIAS_EXT
//
//###############################################################################
//
//ConvolutionTargetEXT enum:
//use EXT_convolution CONVOLUTION_1D_EXT
//use EXT_convolution CONVOLUTION_2D_EXT
//
//###############################################################################

@JvmInline
value class FaceMode(val i: Int) {

    companion object {
        val FRONT = FaceMode(GL11.GL_FRONT)
        val BACK = FaceMode(GL11.GL_BACK)
        val FRONT_AND_BACK = FaceMode(GL11.GL_FRONT_AND_BACK)
    }
}

//###############################################################################

@JvmInline
value class CullFaceMode(val i: Int) {

    companion object {
        val DISABLED = CullFaceMode(GL11.GL_FALSE)
        val FRONT = CullFaceMode(GL11.GL_FRONT)
        val BACK = CullFaceMode(GL11.GL_BACK)
        val FRONT_AND_BACK = CullFaceMode(GL11.GL_FRONT_AND_BACK)
    }
}

//###############################################################################

/** Depth, Stencil and textureCompareMode func */
@JvmInline
value class CompareFunction(val i: Int) {

    companion object {
        val NEVER = CompareFunction(GL11.GL_NEVER)
        val LESS = CompareFunction(GL11.GL_LESS)
        val EQUAL = CompareFunction(GL11.GL_EQUAL)
        val LEQUAL = CompareFunction(GL11.GL_LEQUAL)
        val GREATER = CompareFunction(GL11.GL_GREATER)
        val NOTEQUAL = CompareFunction(GL11.GL_NOTEQUAL)
        val GEQUAL = CompareFunction(GL11.GL_GEQUAL)
        val ALWAYS = CompareFunction(GL11.GL_ALWAYS)
    }
}

//###############################################################################

/** Draw and Read */
typealias BufferMode = Int
//inline class BufferMode(val i: Int) {
//
//    companion object {
//        val NONE = BufferMode(GL11.GL_NONE)
//        val FRONT_LEFT = BufferMode(GL11.GL_FRONT_LEFT)
//        val FRONT_RIGHT = BufferMode(GL11.GL_FRONT_RIGHT)
//        val BACK_LEFT = BufferMode(GL11.GL_BACK_LEFT)
//        val BACK_RIGHT = BufferMode(GL11.GL_BACK_RIGHT)
//        val FRONT = BufferMode(GL11.GL_FRONT)
//        val BACK = BufferMode(GL11.GL_BACK)
//        val LEFT = BufferMode(GL11.GL_LEFT)
//        val RIGHT = BufferMode(GL11.GL_RIGHT)
//        val FRONT_AND_BACK = BufferMode(GL11.GL_FRONT_AND_BACK)
//    }
//}

//###############################################################################

//inline class EnableCap(val i: Int)
//
//val FOG = EnableCap(GL11.GL_FOG)
//val LIGHTING = EnableCap(GL11.GL_LIGHTING)
////val TEXTURE_1D = EnableCap(GL11.GL_TEXTURE_1D)
////val TEXTURE_2D = EnableCap(GL11.GL_TEXTURE_2D)
//val LINE_STIPPLE = EnableCap(GL11.GL_LINE_STIPPLE)
//val POLYGON_STIPPLE = EnableCap(GL11.GL_POLYGON_STIPPLE)
//val CULL_FACE = EnableCap(GL11.GL_CULL_FACE)
//val ALPHA_TEST = EnableCap(GL11.GL_ALPHA_TEST)
//val BLEND = EnableCap(GL11.GL_BLEND)
//val INDEX_LOGIC_OP = EnableCap(GL11.GL_INDEX_LOGIC_OP)
//val COLOR_LOGIC_OP = EnableCap(GL11.GL_COLOR_LOGIC_OP)
//val DITHER = EnableCap(GL11.GL_DITHER)
//val STENCIL_TEST = EnableCap(GL11.GL_STENCIL_TEST)
//val DEPTH_TEST = EnableCap(GL11.GL_DEPTH_TEST)
//val CLIP_PLANE0 = EnableCap(GL11.GL_CLIP_PLANE0)
//val CLIP_PLANE1 = EnableCap(GL11.GL_CLIP_PLANE1)
//val CLIP_PLANE2 = EnableCap(GL11.GL_CLIP_PLANE2)
//use GetPName CLIP_PLANE3
//use GetPName CLIP_PLANE4
//use GetPName CLIP_PLANE5
//use GetPName LIGHT0
//use GetPName LIGHT1
//use GetPName LIGHT2
//use GetPName LIGHT3
//use GetPName LIGHT4
//use GetPName LIGHT5
//use GetPName LIGHT6
//use GetPName LIGHT7
//use GetPName TEXTURE_GEN_S
//use GetPName TEXTURE_GEN_T
//use GetPName TEXTURE_GEN_R
//use GetPName TEXTURE_GEN_Q
//use GetPName MAP1_VERTEX_3
//use GetPName MAP1_VERTEX_4
//use GetPName MAP1_COLOR_4
//use GetPName MAP1_INDEX
//use GetPName MAP1_NORMAL
//use GetPName MAP1_TEXTURE_COORD_1
//use GetPName MAP1_TEXTURE_COORD_2
//use GetPName MAP1_TEXTURE_COORD_3
//use GetPName MAP1_TEXTURE_COORD_4
//use GetPName MAP2_VERTEX_3
//use GetPName MAP2_VERTEX_4
//use GetPName MAP2_COLOR_4
//use GetPName MAP2_INDEX
//use GetPName MAP2_NORMAL
//use GetPName MAP2_TEXTURE_COORD_1
//use GetPName MAP2_TEXTURE_COORD_2
//use GetPName MAP2_TEXTURE_COORD_3
//use GetPName MAP2_TEXTURE_COORD_4
//use GetPName POINT_SMOOTH
//use GetPName LINE_SMOOTH
//use GetPName POLYGON_SMOOTH
//use GetPName SCISSOR_TEST
//use GetPName COLOR_MATERIAL
//use GetPName NORMALIZE
//use GetPName AUTO_NORMAL
//use GetPName POLYGON_OFFSET_POINT
//use GetPName POLYGON_OFFSET_LINE
//use GetPName POLYGON_OFFSET_FILL
//use GetPName VERTEX_ARRAY
//use GetPName NORMAL_ARRAY
//use GetPName COLOR_ARRAY
//use GetPName INDEX_ARRAY
//use GetPName TEXTURE_COORD_ARRAY
//use GetPName EDGE_FLAG_ARRAY
//use EXT_convolution CONVOLUTION_1D_EXT
//use EXT_convolution CONVOLUTION_2D_EXT
//use EXT_convolution SEPARABLE_2D_EXT
//use EXT_histogram HISTOGRAM_EXT
//use EXT_histogram MINMAX_EXT
//use EXT_rescale_normal RESCALE_NORMAL_EXT
//use EXT_shared_texture_palette SHARED_TEXTURE_PALETTE_EXT
//use EXT_texture3D TEXTURE_3D_EXT
//use SGIS_multisample MULTISAMPLE_SGIS
//use SGIS_multisample SAMPLE_ALPHA_TO_MASK_SGIS
//use SGIS_multisample SAMPLE_ALPHA_TO_ONE_SGIS
//use SGIS_multisample SAMPLE_MASK_SGIS
//use SGIS_texture4D TEXTURE_4D_SGIS
//use SGIX_async_histogram ASYNC_HISTOGRAM_SGIX
//use SGIX_async_pixel ASYNC_TEX_IMAGE_SGIX
//use SGIX_async_pixel ASYNC_DRAW_PIXELS_SGIX
//use SGIX_async_pixel ASYNC_READ_PIXELS_SGIX
//use SGIX_calligraphic_fragment CALLIGRAPHIC_FRAGMENT_SGIX
//use SGIX_fog_offset FOG_OFFSET_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHTING_SGIX
//use SGIX_fragment_lighting FRAGMENT_COLOR_MATERIAL_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT0_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT1_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT2_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT3_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT4_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT5_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT6_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT7_SGIX
//use SGIX_framezoom FRAMEZOOM_SGIX
//use SGIX_interlace INTERLACE_SGIX
//use SGIX_ir_instrument1 IR_INSTRUMENT1_SGIX
//use SGIX_pixel_texture PIXEL_TEX_GEN_SGIX
//use SGIS_pixel_texture PIXEL_TEXTURE_SGIS
//use SGIX_reference_plane REFERENCE_PLANE_SGIX
//use SGIX_sprite SPRITE_SGIX
//use SGI_color_table COLOR_TABLE_SGI
//use SGI_color_table POST_CONVOLUTION_COLOR_TABLE_SGI
//use SGI_color_table POST_COLOR_MATRIX_COLOR_TABLE_SGI
//use SGI_texture_color_table TEXTURE_COLOR_TABLE_SGI

//###############################################################################

@JvmInline
value class ErrorCode(val i: Int) {

    companion object {
        val NO_ERROR = ErrorCode(GL11.GL_NO_ERROR)
        val INVALID_ENUM = ErrorCode(GL11.GL_INVALID_ENUM)
        val INVALID_VALUE = ErrorCode(GL11.GL_INVALID_VALUE)
        val INVALID_OPERATION = ErrorCode(GL11.GL_INVALID_OPERATION)
        val STACK_OVERFLOW = ErrorCode(GL11.GL_STACK_OVERFLOW)
        val STACK_UNDERFLOW = ErrorCode(GL11.GL_STACK_UNDERFLOW)
        val OUT_OF_MEMORY = ErrorCode(GL11.GL_OUT_OF_MEMORY)
        val TABLE_TOO_LARGE_EXT = ErrorCode(ARBImaging.GL_TABLE_TOO_LARGE)
        val TEXTURE_TOO_LARGE = ErrorCode(0x8065)
        //# Additional error codes
        //# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_framebuffer_object enum:
        val INVALID_FRAMEBUFFER_OPERATION = ErrorCode(GL30.GL_INVALID_FRAMEBUFFER_OPERATION)
    }
}

//###############################################################################
//
//FeedbackType enum:
//2D						= 0x0600
//3D						= 0x0601
//3D_COLOR					= 0x0602
//3D_COLOR_TEXTURE				= 0x0603
//4D_COLOR_TEXTURE				= 0x0604
//
//###############################################################################
//
//FeedBackToken enum:
//PASS_THROUGH_TOKEN				= 0x0700
//POINT_TOKEN					= 0x0701
//LINE_TOKEN					= 0x0702
//POLYGON_TOKEN					= 0x0703
//BITMAP_TOKEN					= 0x0704
//DRAW_PIXEL_TOKEN				= 0x0705
//COPY_PIXEL_TOKEN				= 0x0706
//LINE_RESET_TOKEN				= 0x0707
//
//###############################################################################
//
//FfdMaskSGIX enum:
//TEXTURE_DEFORMATION_BIT_SGIX			= 0x00000001
//GEOMETRY_DEFORMATION_BIT_SGIX			= 0x00000002
//
//###############################################################################
//
//FfdTargetSGIX enum:
//use SGIX_polynomial_ffd GEOMETRY_DEFORMATION_SGIX
//use SGIX_polynomial_ffd TEXTURE_DEFORMATION_SGIX
//
//###############################################################################
//
//FogMode enum:
//use TextureMagFilter LINEAR
//EXP						= 0x0800
//EXP2						= 0x0801
//use SGIS_fog_function FOG_FUNC_SGIS
//
//###############################################################################
//
//FogParameter enum:
//use GetPName FOG_COLOR
//use GetPName FOG_DENSITY
//use GetPName FOG_END
//use GetPName FOG_INDEX
//use GetPName FOG_MODE
//use GetPName FOG_START
//use SGIX_fog_offset FOG_OFFSET_VALUE_SGIX
//
//###############################################################################
//
//FragmentLightModelParameterSGIX enum:
//use SGIX_fragment_lighting FRAGMENT_LIGHT_MODEL_LOCAL_VIEWER_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT_MODEL_TWO_SIDE_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT_MODEL_AMBIENT_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT_MODEL_NORMAL_INTERPOLATION_SGIX
//
//###############################################################################

@JvmInline
value class FrontFaceDirection(val i: Int) {
    companion object {
        val CW = FrontFaceDirection(GL11.GL_CW)
        val CCW = FrontFaceDirection(GL11.GL_CCW)
    }
}

//###############################################################################
//
//GetColorTableParameterPNameSGI enum:
//use SGI_color_table COLOR_TABLE_SCALE_SGI
//use SGI_color_table COLOR_TABLE_BIAS_SGI
//use SGI_color_table COLOR_TABLE_FORMAT_SGI
//use SGI_color_table COLOR_TABLE_WIDTH_SGI
//use SGI_color_table COLOR_TABLE_RED_SIZE_SGI
//use SGI_color_table COLOR_TABLE_GREEN_SIZE_SGI
//use SGI_color_table COLOR_TABLE_BLUE_SIZE_SGI
//use SGI_color_table COLOR_TABLE_ALPHA_SIZE_SGI
//use SGI_color_table COLOR_TABLE_LUMINANCE_SIZE_SGI
//use SGI_color_table COLOR_TABLE_INTENSITY_SIZE_SGI
//
//###############################################################################
//
//GetConvolutionParameter enum:
//use EXT_convolution CONVOLUTION_BORDER_MODE_EXT
//use EXT_convolution CONVOLUTION_FILTER_SCALE_EXT
//use EXT_convolution CONVOLUTION_FILTER_BIAS_EXT
//use EXT_convolution CONVOLUTION_FORMAT_EXT
//use EXT_convolution CONVOLUTION_WIDTH_EXT
//use EXT_convolution CONVOLUTION_HEIGHT_EXT
//use EXT_convolution MAX_CONVOLUTION_WIDTH_EXT
//use EXT_convolution MAX_CONVOLUTION_HEIGHT_EXT
//
//###############################################################################
//
//GetHistogramParameterPNameEXT enum:
//use EXT_histogram HISTOGRAM_WIDTH_EXT
//use EXT_histogram HISTOGRAM_FORMAT_EXT
//use EXT_histogram HISTOGRAM_RED_SIZE_EXT
//use EXT_histogram HISTOGRAM_GREEN_SIZE_EXT
//use EXT_histogram HISTOGRAM_BLUE_SIZE_EXT
//use EXT_histogram HISTOGRAM_ALPHA_SIZE_EXT
//use EXT_histogram HISTOGRAM_LUMINANCE_SIZE_EXT
//use EXT_histogram HISTOGRAM_SINK_EXT
//
//###############################################################################
//
//GetMapQuery enum:
//COEFF						= 0x0A00
//ORDER						= 0x0A01
//DOMAIN						= 0x0A02
//
//###############################################################################
//
//GetMinmaxParameterPNameEXT enum:
//use EXT_histogram MINMAX_FORMAT_EXT
//use EXT_histogram MINMAX_SINK_EXT
//
//###############################################################################
//
//GetPixelMap enum:
//PIXEL_MAP_I_TO_I				= 0x0C70
//PIXEL_MAP_S_TO_S				= 0x0C71
//PIXEL_MAP_I_TO_R				= 0x0C72
//PIXEL_MAP_I_TO_G				= 0x0C73
//PIXEL_MAP_I_TO_B				= 0x0C74
//PIXEL_MAP_I_TO_A				= 0x0C75
//PIXEL_MAP_R_TO_R				= 0x0C76
//PIXEL_MAP_G_TO_G				= 0x0C77
//PIXEL_MAP_B_TO_B				= 0x0C78
//PIXEL_MAP_A_TO_A				= 0x0C79
//
//###############################################################################
//
//GetPointervPName enum:
//VERTEX_ARRAY_POINTER				= 0x808E
//NORMAL_ARRAY_POINTER				= 0x808F
//COLOR_ARRAY_POINTER				= 0x8090
//INDEX_ARRAY_POINTER				= 0x8091
//TEXTURE_COORD_ARRAY_POINTER			= 0x8092
//EDGE_FLAG_ARRAY_POINTER				= 0x8093
//FEEDBACK_BUFFER_POINTER				= 0x0DF0
//SELECTION_BUFFER_POINTER			= 0x0DF3
//use SGIX_instruments INSTRUMENT_BUFFER_POINTER_SGIX
//
//###############################################################################
//
//# the columns after the comment symbol (#) indicate: number of params, type
//# (F - float, D - double, I - integer) for the returned values
//GetPName enum:
//CURRENT_COLOR					= 0x0B00 # 4 F
//CURRENT_INDEX					= 0x0B01 # 1 F
//CURRENT_NORMAL					= 0x0B02 # 3 F
//CURRENT_TEXTURE_COORDS				= 0x0B03 # 4 F
//CURRENT_RASTER_COLOR				= 0x0B04 # 4 F
//CURRENT_RASTER_INDEX				= 0x0B05 # 1 F
//CURRENT_RASTER_TEXTURE_COORDS			= 0x0B06 # 4 F
//CURRENT_RASTER_POSITION				= 0x0B07 # 4 F
//CURRENT_RASTER_POSITION_VALID			= 0x0B08 # 1 I
//CURRENT_RASTER_DISTANCE				= 0x0B09 # 1 F
//
//POINT_SMOOTH					= 0x0B10 # 1 I
//POINT_SIZE					= 0x0B11 # 1 F
//POINT_SIZE_RANGE				= 0x0B12 # 2 F
//POINT_SIZE_GRANULARITY				= 0x0B13 # 1 F
//
//LINE_SMOOTH					= 0x0B20 # 1 I
//LINE_WIDTH					= 0x0B21 # 1 F
//LINE_WIDTH_RANGE				= 0x0B22 # 2 F
//LINE_WIDTH_GRANULARITY				= 0x0B23 # 1 F
//LINE_STIPPLE					= 0x0B24 # 1 I
//LINE_STIPPLE_PATTERN				= 0x0B25 # 1 I
//LINE_STIPPLE_REPEAT				= 0x0B26 # 1 I
//use VERSION_1_2 SMOOTH_POINT_SIZE_RANGE
//use VERSION_1_2 SMOOTH_POINT_SIZE_GRANULARITY
//use VERSION_1_2 SMOOTH_LINE_WIDTH_RANGE
//use VERSION_1_2 SMOOTH_LINE_WIDTH_GRANULARITY
//use VERSION_1_2 ALIASED_POINT_SIZE_RANGE
//use VERSION_1_2 ALIASED_LINE_WIDTH_RANGE
//
//LIST_MODE					= 0x0B30 # 1 I
//MAX_LIST_NESTING				= 0x0B31 # 1 I
//LIST_BASE					= 0x0B32 # 1 I
//LIST_INDEX					= 0x0B33 # 1 I
//
//POLYGON_MODE					= 0x0B40 # 2 I
//POLYGON_SMOOTH					= 0x0B41 # 1 I
//POLYGON_STIPPLE					= 0x0B42 # 1 I
//EDGE_FLAG					= 0x0B43 # 1 I
//CULL_FACE					= 0x0B44 # 1 I
//CULL_FACE_MODE					= 0x0B45 # 1 I
//FRONT_FACE					= 0x0B46 # 1 I
//
//LIGHTING					= 0x0B50 # 1 I
//LIGHT_MODEL_LOCAL_VIEWER			= 0x0B51 # 1 I
//LIGHT_MODEL_TWO_SIDE				= 0x0B52 # 1 I
//LIGHT_MODEL_AMBIENT				= 0x0B53 # 4 F
//SHADE_MODEL					= 0x0B54 # 1 I
//COLOR_MATERIAL_FACE				= 0x0B55 # 1 I
//COLOR_MATERIAL_PARAMETER			= 0x0B56 # 1 I
//COLOR_MATERIAL					= 0x0B57 # 1 I
//
//FOG						= 0x0B60 # 1 I
//FOG_INDEX					= 0x0B61 # 1 I
//FOG_DENSITY					= 0x0B62 # 1 F
//FOG_START					= 0x0B63 # 1 F
//FOG_END						= 0x0B64 # 1 F
//FOG_MODE					= 0x0B65 # 1 I
//FOG_COLOR					= 0x0B66 # 4 F
//
//DEPTH_RANGE					= 0x0B70 # 2 F
//DEPTH_TEST					= 0x0B71 # 1 I
//DEPTH_WRITEMASK					= 0x0B72 # 1 I
//DEPTH_CLEAR_VALUE				= 0x0B73 # 1 F
//DEPTH_FUNC					= 0x0B74 # 1 I
//
//ACCUM_CLEAR_VALUE				= 0x0B80 # 4 F
//
//STENCIL_TEST					= 0x0B90 # 1 I
//STENCIL_CLEAR_VALUE				= 0x0B91 # 1 I
//STENCIL_FUNC					= 0x0B92 # 1 I
//STENCIL_VALUE_MASK				= 0x0B93 # 1 I
//STENCIL_FAIL					= 0x0B94 # 1 I
//STENCIL_PASS_DEPTH_FAIL				= 0x0B95 # 1 I
//STENCIL_PASS_DEPTH_PASS				= 0x0B96 # 1 I
//STENCIL_REF					= 0x0B97 # 1 I
//STENCIL_WRITEMASK				= 0x0B98 # 1 I
//
//MATRIX_MODE					= 0x0BA0 # 1 I
//NORMALIZE					= 0x0BA1 # 1 I
//VIEWPORT					= 0x0BA2 # 4 I
//MODELVIEW_STACK_DEPTH				= 0x0BA3 # 1 I
//PROJECTION_STACK_DEPTH				= 0x0BA4 # 1 I
//TEXTURE_STACK_DEPTH				= 0x0BA5 # 1 I
//MODELVIEW_MATRIX				= 0x0BA6 # 16 F
//PROJECTION_MATRIX				= 0x0BA7 # 16 F
//TEXTURE_MATRIX					= 0x0BA8 # 16 F
//
//ATTRIB_STACK_DEPTH				= 0x0BB0 # 1 I
//CLIENT_ATTRIB_STACK_DEPTH			= 0x0BB1 # 1 I
//
//ALPHA_TEST					= 0x0BC0 # 1 I
//ALPHA_TEST_FUNC					= 0x0BC1 # 1 I
//ALPHA_TEST_REF					= 0x0BC2 # 1 F
//
//DITHER						= 0x0BD0 # 1 I
//
//BLEND_DST					= 0x0BE0 # 1 I
//BLEND_SRC					= 0x0BE1 # 1 I
//BLEND						= 0x0BE2 # 1 I
//
//LOGIC_OP_MODE					= 0x0BF0 # 1 I
//INDEX_LOGIC_OP					= 0x0BF1 # 1 I
//LOGIC_OP					= 0x0BF1 # 1 I
//COLOR_LOGIC_OP					= 0x0BF2 # 1 I
//
//AUX_BUFFERS					= 0x0C00 # 1 I
//DRAW_BUFFER					= 0x0C01 # 1 I
//READ_BUFFER					= 0x0C02 # 1 I
//
//SCISSOR_BOX					= 0x0C10 # 4 I
//SCISSOR_TEST					= 0x0C11 # 1 I
//
//INDEX_CLEAR_VALUE				= 0x0C20 # 1 I
//INDEX_WRITEMASK					= 0x0C21 # 1 I
//COLOR_CLEAR_VALUE				= 0x0C22 # 4 F
//COLOR_WRITEMASK					= 0x0C23 # 4 I
//
//INDEX_MODE					= 0x0C30 # 1 I
//RGBA_MODE					= 0x0C31 # 1 I
//DOUBLEBUFFER					= 0x0C32 # 1 I
//STEREO						= 0x0C33 # 1 I
//
//RENDER_MODE					= 0x0C40 # 1 I
//
//PERSPECTIVE_CORRECTION_HINT			= 0x0C50 # 1 I
//POINT_SMOOTH_HINT				= 0x0C51 # 1 I
//LINE_SMOOTH_HINT				= 0x0C52 # 1 I
//POLYGON_SMOOTH_HINT				= 0x0C53 # 1 I
//FOG_HINT					= 0x0C54 # 1 I
//
//TEXTURE_GEN_S					= 0x0C60 # 1 I
//TEXTURE_GEN_T					= 0x0C61 # 1 I
//TEXTURE_GEN_R					= 0x0C62 # 1 I
//TEXTURE_GEN_Q					= 0x0C63 # 1 I
//
//PIXEL_MAP_I_TO_I_SIZE				= 0x0CB0 # 1 I
//PIXEL_MAP_S_TO_S_SIZE				= 0x0CB1 # 1 I
//PIXEL_MAP_I_TO_R_SIZE				= 0x0CB2 # 1 I
//PIXEL_MAP_I_TO_G_SIZE				= 0x0CB3 # 1 I
//PIXEL_MAP_I_TO_B_SIZE				= 0x0CB4 # 1 I
//PIXEL_MAP_I_TO_A_SIZE				= 0x0CB5 # 1 I
//PIXEL_MAP_R_TO_R_SIZE				= 0x0CB6 # 1 I
//PIXEL_MAP_G_TO_G_SIZE				= 0x0CB7 # 1 I
//PIXEL_MAP_B_TO_B_SIZE				= 0x0CB8 # 1 I
//PIXEL_MAP_A_TO_A_SIZE				= 0x0CB9 # 1 I
//
//UNPACK_SWAP_BYTES				= 0x0CF0 # 1 I
//UNPACK_LSB_FIRST				= 0x0CF1 # 1 I
//UNPACK_ROW_LENGTH				= 0x0CF2 # 1 I
//UNPACK_SKIP_ROWS				= 0x0CF3 # 1 I
//UNPACK_SKIP_PIXELS				= 0x0CF4 # 1 I
//UNPACK_ALIGNMENT				= 0x0CF5 # 1 I
//
//PACK_SWAP_BYTES					= 0x0D00 # 1 I
//PACK_LSB_FIRST					= 0x0D01 # 1 I
//PACK_ROW_LENGTH					= 0x0D02 # 1 I
//PACK_SKIP_ROWS					= 0x0D03 # 1 I
//PACK_SKIP_PIXELS				= 0x0D04 # 1 I
//PACK_ALIGNMENT					= 0x0D05 # 1 I
//
//MAP_COLOR					= 0x0D10 # 1 I
//MAP_STENCIL					= 0x0D11 # 1 I
//INDEX_SHIFT					= 0x0D12 # 1 I
//INDEX_OFFSET					= 0x0D13 # 1 I
//RED_SCALE					= 0x0D14 # 1 F
//RED_BIAS					= 0x0D15 # 1 F
//ZOOM_X						= 0x0D16 # 1 F
//ZOOM_Y						= 0x0D17 # 1 F
//GREEN_SCALE					= 0x0D18 # 1 F
//GREEN_BIAS					= 0x0D19 # 1 F
//BLUE_SCALE					= 0x0D1A # 1 F
//BLUE_BIAS					= 0x0D1B # 1 F
//ALPHA_SCALE					= 0x0D1C # 1 F
//ALPHA_BIAS					= 0x0D1D # 1 F
//DEPTH_SCALE					= 0x0D1E # 1 F
//DEPTH_BIAS					= 0x0D1F # 1 F
//
//MAX_EVAL_ORDER					= 0x0D30 # 1 I
//MAX_LIGHTS					= 0x0D31 # 1 I
//# VERSION_3_0 enum: (aliases)
//#	MAX_CLIP_DISTANCES				= GL_MAX_CLIP_PLANES	# 3.0
//MAX_CLIP_PLANES					= 0x0D32 # 1 I
//MAX_TEXTURE_SIZE				= 0x0D33 # 1 I
//MAX_PIXEL_MAP_TABLE				= 0x0D34 # 1 I
//MAX_ATTRIB_STACK_DEPTH				= 0x0D35 # 1 I
//MAX_MODELVIEW_STACK_DEPTH			= 0x0D36 # 1 I
//MAX_NAME_STACK_DEPTH				= 0x0D37 # 1 I
//MAX_PROJECTION_STACK_DEPTH			= 0x0D38 # 1 I
//MAX_TEXTURE_STACK_DEPTH				= 0x0D39 # 1 I
//MAX_VIEWPORT_DIMS				= 0x0D3A # 2 F
//MAX_CLIENT_ATTRIB_STACK_DEPTH			= 0x0D3B # 1 I
//
//SUBPIXEL_BITS					= 0x0D50 # 1 I
//INDEX_BITS					= 0x0D51 # 1 I
//RED_BITS					= 0x0D52 # 1 I
//GREEN_BITS					= 0x0D53 # 1 I
//BLUE_BITS					= 0x0D54 # 1 I
//ALPHA_BITS					= 0x0D55 # 1 I
//DEPTH_BITS					= 0x0D56 # 1 I
//STENCIL_BITS					= 0x0D57 # 1 I
//ACCUM_RED_BITS					= 0x0D58 # 1 I
//ACCUM_GREEN_BITS				= 0x0D59 # 1 I
//ACCUM_BLUE_BITS					= 0x0D5A # 1 I
//ACCUM_ALPHA_BITS				= 0x0D5B # 1 I
//
//NAME_STACK_DEPTH				= 0x0D70 # 1 I
//
//AUTO_NORMAL					= 0x0D80 # 1 I
//
//MAP1_COLOR_4					= 0x0D90 # 1 I
//MAP1_INDEX					= 0x0D91 # 1 I
//MAP1_NORMAL					= 0x0D92 # 1 I
//MAP1_TEXTURE_COORD_1				= 0x0D93 # 1 I
//MAP1_TEXTURE_COORD_2				= 0x0D94 # 1 I
//MAP1_TEXTURE_COORD_3				= 0x0D95 # 1 I
//MAP1_TEXTURE_COORD_4				= 0x0D96 # 1 I
//MAP1_VERTEX_3					= 0x0D97 # 1 I
//MAP1_VERTEX_4					= 0x0D98 # 1 I
//
//MAP2_COLOR_4					= 0x0DB0 # 1 I
//MAP2_INDEX					= 0x0DB1 # 1 I
//MAP2_NORMAL					= 0x0DB2 # 1 I
//MAP2_TEXTURE_COORD_1				= 0x0DB3 # 1 I
//MAP2_TEXTURE_COORD_2				= 0x0DB4 # 1 I
//MAP2_TEXTURE_COORD_3				= 0x0DB5 # 1 I
//MAP2_TEXTURE_COORD_4				= 0x0DB6 # 1 I
//MAP2_VERTEX_3					= 0x0DB7 # 1 I
//MAP2_VERTEX_4					= 0x0DB8 # 1 I
//
//MAP1_GRID_DOMAIN				= 0x0DD0 # 2 F
//MAP1_GRID_SEGMENTS				= 0x0DD1 # 1 I
//MAP2_GRID_DOMAIN				= 0x0DD2 # 4 F
//MAP2_GRID_SEGMENTS				= 0x0DD3 # 2 I
//
//TEXTURE_1D					= 0x0DE0 # 1 I
//TEXTURE_2D					= 0x0DE1 # 1 I
//
//FEEDBACK_BUFFER_SIZE				= 0x0DF1 # 1 I
//FEEDBACK_BUFFER_TYPE				= 0x0DF2 # 1 I
//
//SELECTION_BUFFER_SIZE				= 0x0DF4 # 1 I
//
//POLYGON_OFFSET_UNITS				= 0x2A00 # 1 F
//POLYGON_OFFSET_POINT				= 0x2A01 # 1 I
//POLYGON_OFFSET_LINE				= 0x2A02 # 1 I
//POLYGON_OFFSET_FILL				= 0x8037 # 1 I
//POLYGON_OFFSET_FACTOR				= 0x8038 # 1 F
//
//TEXTURE_BINDING_1D				= 0x8068 # 1 I
//TEXTURE_BINDING_2D				= 0x8069 # 1 I
//TEXTURE_BINDING_3D				= 0x806A # 1 I
//
//VERTEX_ARRAY					= 0x8074 # 1 I
//NORMAL_ARRAY					= 0x8075 # 1 I
//COLOR_ARRAY					= 0x8076 # 1 I
//INDEX_ARRAY					= 0x8077 # 1 I
//TEXTURE_COORD_ARRAY				= 0x8078 # 1 I
//EDGE_FLAG_ARRAY					= 0x8079 # 1 I
//
//VERTEX_ARRAY_SIZE				= 0x807A # 1 I
//VERTEX_ARRAY_TYPE				= 0x807B # 1 I
//VERTEX_ARRAY_STRIDE				= 0x807C # 1 I
//
//NORMAL_ARRAY_TYPE				= 0x807E # 1 I
//NORMAL_ARRAY_STRIDE				= 0x807F # 1 I
//
//COLOR_ARRAY_SIZE				= 0x8081 # 1 I
//COLOR_ARRAY_TYPE				= 0x8082 # 1 I
//COLOR_ARRAY_STRIDE				= 0x8083 # 1 I
//
//INDEX_ARRAY_TYPE				= 0x8085 # 1 I
//INDEX_ARRAY_STRIDE				= 0x8086 # 1 I
//
//TEXTURE_COORD_ARRAY_SIZE			= 0x8088 # 1 I
//TEXTURE_COORD_ARRAY_TYPE			= 0x8089 # 1 I
//TEXTURE_COORD_ARRAY_STRIDE			= 0x808A # 1 I
//
//EDGE_FLAG_ARRAY_STRIDE				= 0x808C # 1 I
//
//use ClipPlaneName CLIP_PLANE0
//use ClipPlaneName CLIP_PLANE1
//use ClipPlaneName CLIP_PLANE2
//use ClipPlaneName CLIP_PLANE3
//use ClipPlaneName CLIP_PLANE4
//use ClipPlaneName CLIP_PLANE5
//
//use LightName LIGHT0
//use LightName LIGHT1
//use LightName LIGHT2
//use LightName LIGHT3
//use LightName LIGHT4
//use LightName LIGHT5
//use LightName LIGHT6
//use LightName LIGHT7
//
//#	 use ARB_transpose_matrix TRANSPOSE_MODELVIEW_MATRIX_ARB
//#	 use ARB_transpose_matrix TRANSPOSE_PROJECTION_MATRIX_ARB
//#	 use ARB_transpose_matrix TRANSPOSE_TEXTURE_MATRIX_ARB
//#	 use ARB_transpose_matrix TRANSPOSE_COLOR_MATRIX_ARB
//
//use VERSION_1_2 LIGHT_MODEL_COLOR_CONTROL
//
//use EXT_blend_color BLEND_COLOR_EXT
//
//use EXT_blend_minmax BLEND_EQUATION_EXT
//
//use EXT_cmyka PACK_CMYK_HINT_EXT
//use EXT_cmyka UNPACK_CMYK_HINT_EXT
//
//use EXT_convolution CONVOLUTION_1D_EXT
//use EXT_convolution CONVOLUTION_2D_EXT
//use EXT_convolution SEPARABLE_2D_EXT
//use EXT_convolution POST_CONVOLUTION_RED_SCALE_EXT
//use EXT_convolution POST_CONVOLUTION_GREEN_SCALE_EXT
//use EXT_convolution POST_CONVOLUTION_BLUE_SCALE_EXT
//use EXT_convolution POST_CONVOLUTION_ALPHA_SCALE_EXT
//use EXT_convolution POST_CONVOLUTION_RED_BIAS_EXT
//use EXT_convolution POST_CONVOLUTION_GREEN_BIAS_EXT
//use EXT_convolution POST_CONVOLUTION_BLUE_BIAS_EXT
//use EXT_convolution POST_CONVOLUTION_ALPHA_BIAS_EXT
//
//use EXT_histogram HISTOGRAM_EXT
//use EXT_histogram MINMAX_EXT
//
//use EXT_polygon_offset POLYGON_OFFSET_BIAS_EXT
//
//use EXT_rescale_normal RESCALE_NORMAL_EXT
//
//use EXT_shared_texture_palette SHARED_TEXTURE_PALETTE_EXT
//
//use EXT_texture_object TEXTURE_3D_BINDING_EXT
//
//use EXT_texture3D PACK_SKIP_IMAGES_EXT
//use EXT_texture3D PACK_IMAGE_HEIGHT_EXT
//use EXT_texture3D UNPACK_SKIP_IMAGES_EXT
//use EXT_texture3D UNPACK_IMAGE_HEIGHT_EXT
//use EXT_texture3D TEXTURE_3D_EXT
//use EXT_texture3D MAX_3D_TEXTURE_SIZE_EXT
//
//use EXT_vertex_array VERTEX_ARRAY_COUNT_EXT
//use EXT_vertex_array NORMAL_ARRAY_COUNT_EXT
//use EXT_vertex_array COLOR_ARRAY_COUNT_EXT
//use EXT_vertex_array INDEX_ARRAY_COUNT_EXT
//use EXT_vertex_array TEXTURE_COORD_ARRAY_COUNT_EXT
//use EXT_vertex_array EDGE_FLAG_ARRAY_COUNT_EXT
//
//use SGIS_detail_texture DETAIL_TEXTURE_2D_BINDING_SGIS
//
//use SGIS_fog_function FOG_FUNC_POINTS_SGIS
//use SGIS_fog_function MAX_FOG_FUNC_POINTS_SGIS
//
//use SGIS_generate_mipmap GENERATE_MIPMAP_HINT_SGIS
//
//use SGIS_multisample MULTISAMPLE_SGIS
//use SGIS_multisample SAMPLE_ALPHA_TO_MASK_SGIS
//use SGIS_multisample SAMPLE_ALPHA_TO_ONE_SGIS
//use SGIS_multisample SAMPLE_MASK_SGIS
//use SGIS_multisample SAMPLE_BUFFERS_SGIS
//use SGIS_multisample SAMPLES_SGIS
//use SGIS_multisample SAMPLE_MASK_VALUE_SGIS
//use SGIS_multisample SAMPLE_MASK_INVERT_SGIS
//use SGIS_multisample SAMPLE_PATTERN_SGIS
//
//use SGIS_pixel_texture PIXEL_TEXTURE_SGIS
//
//use SGIS_point_parameters POINT_SIZE_MIN_SGIS
//use SGIS_point_parameters POINT_SIZE_MAX_SGIS
//use SGIS_point_parameters POINT_FADE_THRESHOLD_SIZE_SGIS
//use SGIS_point_parameters DISTANCE_ATTENUATION_SGIS
//
//use SGIS_texture4D PACK_SKIP_VOLUMES_SGIS
//use SGIS_texture4D PACK_IMAGE_DEPTH_SGIS
//use SGIS_texture4D UNPACK_SKIP_VOLUMES_SGIS
//use SGIS_texture4D UNPACK_IMAGE_DEPTH_SGIS
//use SGIS_texture4D TEXTURE_4D_SGIS
//use SGIS_texture4D MAX_4D_TEXTURE_SIZE_SGIS
//use SGIS_texture4D TEXTURE_4D_BINDING_SGIS
//
//use SGIX_async ASYNC_MARKER_SGIX
//
//use SGIX_async_histogram ASYNC_HISTOGRAM_SGIX
//use SGIX_async_histogram MAX_ASYNC_HISTOGRAM_SGIX
//
//use SGIX_async_pixel ASYNC_TEX_IMAGE_SGIX
//use SGIX_async_pixel ASYNC_DRAW_PIXELS_SGIX
//use SGIX_async_pixel ASYNC_READ_PIXELS_SGIX
//use SGIX_async_pixel MAX_ASYNC_TEX_IMAGE_SGIX
//use SGIX_async_pixel MAX_ASYNC_DRAW_PIXELS_SGIX
//use SGIX_async_pixel MAX_ASYNC_READ_PIXELS_SGIX
//
//use SGIX_calligraphic_fragment CALLIGRAPHIC_FRAGMENT_SGIX
//
//use SGIX_clipmap MAX_CLIPMAP_VIRTUAL_DEPTH_SGIX
//use SGIX_clipmap MAX_CLIPMAP_DEPTH_SGIX
//
//use SGIX_convolution_accuracy CONVOLUTION_HINT_SGIX
//
//use SGIX_fog_offset FOG_OFFSET_SGIX
//use SGIX_fog_offset FOG_OFFSET_VALUE_SGIX
//
//use SGIX_fragment_lighting FRAGMENT_LIGHTING_SGIX
//use SGIX_fragment_lighting FRAGMENT_COLOR_MATERIAL_SGIX
//use SGIX_fragment_lighting FRAGMENT_COLOR_MATERIAL_FACE_SGIX
//use SGIX_fragment_lighting FRAGMENT_COLOR_MATERIAL_PARAMETER_SGIX
//use SGIX_fragment_lighting MAX_FRAGMENT_LIGHTS_SGIX
//use SGIX_fragment_lighting MAX_ACTIVE_LIGHTS_SGIX
//use SGIX_fragment_lighting LIGHT_ENV_MODE_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT_MODEL_LOCAL_VIEWER_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT_MODEL_TWO_SIDE_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT_MODEL_AMBIENT_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT_MODEL_NORMAL_INTERPOLATION_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT0_SGIX
//
//use SGIX_framezoom FRAMEZOOM_SGIX
//use SGIX_framezoom FRAMEZOOM_FACTOR_SGIX
//use SGIX_framezoom MAX_FRAMEZOOM_FACTOR_SGIX
//
//use SGIX_instruments INSTRUMENT_MEASUREMENTS_SGIX
//
//use SGIX_interlace INTERLACE_SGIX
//
//use SGIX_ir_instrument1 IR_INSTRUMENT1_SGIX
//
//use SGIX_pixel_texture PIXEL_TEX_GEN_SGIX
//use SGIX_pixel_texture PIXEL_TEX_GEN_MODE_SGIX
//
//use SGIX_pixel_tiles PIXEL_TILE_BEST_ALIGNMENT_SGIX
//use SGIX_pixel_tiles PIXEL_TILE_CACHE_INCREMENT_SGIX
//use SGIX_pixel_tiles PIXEL_TILE_WIDTH_SGIX
//use SGIX_pixel_tiles PIXEL_TILE_HEIGHT_SGIX
//use SGIX_pixel_tiles PIXEL_TILE_GRID_WIDTH_SGIX
//use SGIX_pixel_tiles PIXEL_TILE_GRID_HEIGHT_SGIX
//use SGIX_pixel_tiles PIXEL_TILE_GRID_DEPTH_SGIX
//use SGIX_pixel_tiles PIXEL_TILE_CACHE_SIZE_SGIX
//
//use SGIX_polynomial_ffd DEFORMATIONS_MASK_SGIX
//
//use SGIX_reference_plane REFERENCE_PLANE_EQUATION_SGIX
//use SGIX_reference_plane REFERENCE_PLANE_SGIX
//
//use SGIX_sprite SPRITE_SGIX
//use SGIX_sprite SPRITE_MODE_SGIX
//use SGIX_sprite SPRITE_AXIS_SGIX
//use SGIX_sprite SPRITE_TRANSLATION_SGIX
//
//use SGIX_subsample PACK_SUBSAMPLE_RATE_SGIX
//use SGIX_subsample UNPACK_SUBSAMPLE_RATE_SGIX
//use SGIX_resample PACK_RESAMPLE_SGIX
//use SGIX_resample UNPACK_RESAMPLE_SGIX
//
//use SGIX_texture_scale_bias POST_TEXTURE_FILTER_BIAS_RANGE_SGIX
//use SGIX_texture_scale_bias POST_TEXTURE_FILTER_SCALE_RANGE_SGIX
//
//use SGIX_vertex_preclip VERTEX_PRECLIP_SGIX
//use SGIX_vertex_preclip VERTEX_PRECLIP_HINT_SGIX
//
//use SGI_color_matrix COLOR_MATRIX_SGI
//use SGI_color_matrix COLOR_MATRIX_STACK_DEPTH_SGI
//use SGI_color_matrix MAX_COLOR_MATRIX_STACK_DEPTH_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_RED_SCALE_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_GREEN_SCALE_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_BLUE_SCALE_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_ALPHA_SCALE_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_RED_BIAS_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_GREEN_BIAS_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_BLUE_BIAS_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_ALPHA_BIAS_SGI
//
//use SGI_color_table COLOR_TABLE_SGI
//use SGI_color_table POST_CONVOLUTION_COLOR_TABLE_SGI
//use SGI_color_table POST_COLOR_MATRIX_COLOR_TABLE_SGI
//
//use SGI_texture_color_table TEXTURE_COLOR_TABLE_SGI
//
//###############################################################################

@JvmInline
value class TexLevelParameter(val i: Int) {
    companion object {
        val WIDTH = TexLevelParameter(GL11.GL_TEXTURE_WIDTH)
        val HEIGHT = TexLevelParameter(GL11.GL_TEXTURE_HEIGHT)
        val DEPTH = TexLevelParameter(GL12.GL_TEXTURE_DEPTH)
        val INTERNAL_FORMAT = TexLevelParameter(GL11.GL_TEXTURE_INTERNAL_FORMAT)
        val COMPONENTS = TexLevelParameter(GL11.GL_TEXTURE_COMPONENTS)
        val RED_TYPE = TexLevelParameter(GL30.GL_TEXTURE_RED_TYPE)
        val GREEN_TYPE = TexLevelParameter(GL30.GL_TEXTURE_GREEN_TYPE)
        val BLUE_TYPE = TexLevelParameter(GL30.GL_TEXTURE_BLUE_TYPE)
        val ALPHA_TYPE = TexLevelParameter(GL30.GL_TEXTURE_ALPHA_TYPE)
        val DEPTH_TYPE = TexLevelParameter(GL30.GL_TEXTURE_DEPTH_TYPE)
        val RED_SIZE = TexLevelParameter(GL11.GL_TEXTURE_RED_SIZE)
        val GREEN_SIZE = TexLevelParameter(GL11.GL_TEXTURE_GREEN_SIZE)
        val BLUE_SIZE = TexLevelParameter(GL11.GL_TEXTURE_BLUE_SIZE)
        val ALPHA_SIZE = TexLevelParameter(GL11.GL_TEXTURE_ALPHA_SIZE)
        val DEPTH_SIZE = TexLevelParameter(GL30.GL_TEXTURE_DEPTH_SIZE)
        val COMPRESSED = TexLevelParameter(GL30.GL_TEXTURE_COMPRESSED)
        val COMPRESSED_IMAGE_SIZE = TexLevelParameter(GL13.GL_TEXTURE_COMPRESSED_IMAGE_SIZE)
        val BUFFER_OFFSET = TexLevelParameter(GL43.GL_TEXTURE_BUFFER_OFFSET)
        val BUFFER_SIZE = TexLevelParameter(GL43.GL_TEXTURE_BUFFER_SIZE)
    }
}


@JvmInline
value class TexParameter(val i: Int) {
    companion object {
        val DEPTH_STENCIL_MODE = TexParameter(GL43.GL_DEPTH_STENCIL_TEXTURE_MODE)
        val IMAGE_FORMAT_COMPATIBILITY_TYPE = TexParameter(GL42.GL_IMAGE_FORMAT_COMPATIBILITY_TYPE)
        val BASE_LEVEL = TexParameter(GL12.GL_TEXTURE_BASE_LEVEL)
        val BORDER_COLOR = TexParameter(GL11.GL_TEXTURE_BORDER_COLOR)
        val COMPARE_MODE = TexParameter(GL14.GL_TEXTURE_COMPARE_MODE)
        val COMPARE_FUNC = TexParameter(GL14.GL_TEXTURE_COMPARE_FUNC)
        val IMMUTABLE_FORMAT = TexParameter(GL42.GL_TEXTURE_IMMUTABLE_FORMAT)
        val IMMUTABLE_LEVELS = TexParameter(GL43.GL_TEXTURE_IMMUTABLE_LEVELS)
        val LOD_BIAS = TexParameter(GL14.GL_TEXTURE_LOD_BIAS)
        val MAG_FILTER = TexParameter(GL11.GL_TEXTURE_MAG_FILTER)
        val MAX_LEVEL = TexParameter(GL12.GL_TEXTURE_MAX_LEVEL)
        val MAX_LOD = TexParameter(GL12.GL_TEXTURE_MAX_LOD)
        val MIN_FILTER = TexParameter(GL11.GL_TEXTURE_MIN_FILTER)
        val MIN_LOD = TexParameter(GL12.GL_TEXTURE_MIN_LOD)
        val SWIZZLE_R = TexParameter(GL33.GL_TEXTURE_SWIZZLE_R)
        val SWIZZLE_G = TexParameter(GL33.GL_TEXTURE_SWIZZLE_G)
        val SWIZZLE_B = TexParameter(GL33.GL_TEXTURE_SWIZZLE_B)
        val SWIZZLE_A = TexParameter(GL33.GL_TEXTURE_SWIZZLE_A)
        val SWIZZLE_RGBA = TexParameter(GL33.GL_TEXTURE_SWIZZLE_RGBA)
        val TARGET = TexParameter(GL45.GL_TEXTURE_TARGET)
        val VIEW_MIN_LAYER = TexParameter(GL43.GL_TEXTURE_VIEW_MIN_LAYER)
        val VIEW_MIN_LEVEL = TexParameter(GL43.GL_TEXTURE_VIEW_MIN_LEVEL)
        val VIEW_NUM_LAYERS = TexParameter(GL43.GL_TEXTURE_VIEW_NUM_LAYERS)
        val VIEW_NUM_LEVELS = TexParameter(GL43.GL_TEXTURE_VIEW_NUM_LEVELS)
        val WRAP_S = TexParameter(GL11.GL_TEXTURE_WRAP_S)
        val WRAP_T = TexParameter(GL11.GL_TEXTURE_WRAP_T)
        val WRAP_R = TexParameter(GL12.GL_TEXTURE_WRAP_R)
    }
}

@JvmInline
value class SamplerParameter(val i: Int) {
    companion object {
        val BORDER_COLOR = SamplerParameter(GL11.GL_TEXTURE_BORDER_COLOR)
        val COMPARE_MODE = SamplerParameter(GL14.GL_TEXTURE_COMPARE_MODE)
        val COMPARE_FUNC = SamplerParameter(GL14.GL_TEXTURE_COMPARE_FUNC)
        val LOD_BIAS = SamplerParameter(GL14.GL_TEXTURE_LOD_BIAS)
        val MAG_FILTER = SamplerParameter(GL11.GL_TEXTURE_MAG_FILTER)
        val MAX_LOD = SamplerParameter(GL12.GL_TEXTURE_MAX_LOD)
        val MIN_FILTER = SamplerParameter(GL11.GL_TEXTURE_MIN_FILTER)
        val MIN_LOD = SamplerParameter(GL12.GL_TEXTURE_MIN_LOD)
        val WRAP_S = SamplerParameter(GL11.GL_TEXTURE_WRAP_S)
        val WRAP_T = SamplerParameter(GL11.GL_TEXTURE_WRAP_T)
        val WRAP_R = SamplerParameter(GL12.GL_TEXTURE_WRAP_R)
    }
}

//###############################################################################

@JvmInline
value class HintMode(val i: Int) {
    companion object {
        val DONT_CARE = HintMode(GL11.GL_DONT_CARE)
        val FASTEST = HintMode(GL11.GL_FASTEST)
        val NICEST = HintMode(GL11.GL_NICEST)
    }
}

//###############################################################################

@JvmInline
value class HintTarget(val i: Int) {
    companion object {
//        val PERSPECTIVE_CORRECTION_HINT = HintTarget(GL11.GL_PERSPECTIVE_CORRECTION_HINT)
//        val POINT_SMOOTH_HINT = HintTarget(GL11.GL_POINT_SMOOTH_HINT)
        val LINE_SMOOTH = HintTarget(GL11.GL_LINE_SMOOTH_HINT)
        val POLYGON_SMOOTH = HintTarget(GL11.GL_POLYGON_SMOOTH_HINT)
//        val FOG_HINT = HintTarget(GL11.GL_FOG_HINT)
//        val PACK_CMYK_HINT_EXT = HintTarget(0x800e)
//        val UNPACK_CMYK_HINT_EXT = HintTarget(0x800f)
        val TEXTURE_COMPRESSION = HintTarget(GL13.GL_TEXTURE_COMPRESSION_HINT)
        val FRAGMENT_SHADER_DERIVATIVE = HintTarget(GL20.GL_FRAGMENT_SHADER_DERIVATIVE_HINT)
    }
}

//###############################################################################
//
//HistogramTargetEXT enum:
//use EXT_histogram HISTOGRAM_EXT
//use EXT_histogram PROXY_HISTOGRAM_EXT
//
//###############################################################################
//
//IndexPointerType enum:
//use DataType SHORT
//use DataType INT
//use DataType FLOAT
//use DataType DOUBLE
//
//###############################################################################
//
//LightEnvModeSGIX enum:
//use StencilOp REPLACE
//use TextureEnvMode MODULATE
//use AccumOp ADD
//
//###############################################################################
//
//LightEnvParameterSGIX enum:
//use SGIX_fragment_lighting LIGHT_ENV_MODE_SGIX
//
//###############################################################################
//
//LightModelColorControl enum:
//use VERSION_1_2 SINGLE_COLOR
//use VERSION_1_2 SEPARATE_SPECULAR_COLOR
//
//###############################################################################
//
//LightModelParameter enum:
//use GetPName LIGHT_MODEL_AMBIENT
//use GetPName LIGHT_MODEL_LOCAL_VIEWER
//use GetPName LIGHT_MODEL_TWO_SIDE
//use VERSION_1_2 LIGHT_MODEL_COLOR_CONTROL
//
//###############################################################################
//
//LightParameter enum:
//AMBIENT						= 0x1200
//DIFFUSE						= 0x1201
//SPECULAR					= 0x1202
//POSITION					= 0x1203
//SPOT_DIRECTION					= 0x1204
//SPOT_EXPONENT					= 0x1205
//SPOT_CUTOFF					= 0x1206
//CONSTANT_ATTENUATION				= 0x1207
//LINEAR_ATTENUATION				= 0x1208
//QUADRATIC_ATTENUATION				= 0x1209
//
//###############################################################################
//
//ListMode enum:
//COMPILE						= 0x1300
//COMPILE_AND_EXECUTE				= 0x1301
//
//###############################################################################

@JvmInline
value class DataType(val i: Int) {
    companion object {
        val BYTE = DataType(GL11.GL_BYTE)
        val UNSIGNED_BYTE = DataType(GL11.GL_UNSIGNED_BYTE)
        val SHORT = DataType(GL11.GL_SHORT)
        val UNSIGNED_SHORT = DataType(GL11.GL_UNSIGNED_SHORT)
        val INT = DataType(GL11.GL_INT)
        val UNSIGNED_INT = DataType(GL11.GL_UNSIGNED_INT)
        val FLOAT = DataType(GL11.GL_FLOAT)
        val _2_BYTES = DataType(GL11.GL_2_BYTES)
        val _3_BYTES = DataType(GL11.GL_3_BYTES)
        val _4_BYTES = DataType(GL11.GL_4_BYTES)
        val DOUBLE = DataType(GL11.GL_DOUBLE)
        //# VERSION_3_0 enum:
//# ARB_half_float_vertex enum: (note: no ARB suffixes)
//# ARB_half_float_pixel enum:
//# NV_half_float enum:
        val HALF_FLOAT = DataType(GL30.GL_HALF_FLOAT) //    # 3.0 / ARB_half_float_vertex
//#	HALF_FLOAT_ARB					= 0x140B
//#	HALF_FLOAT_NV					= 0x140B

//# OES_fixed_point enum:
//val FIXED_OES = DataType(0x140C)
    }

    val size: Int
        get() = when (i) {
            GL11.GL_BYTE, GL11.GL_UNSIGNED_BYTE -> Byte.BYTES
            GL11.GL_SHORT, GL11.GL_UNSIGNED_SHORT -> Short.BYTES
            GL11.GL_INT, GL11.GL_UNSIGNED_INT -> Int.BYTES
            GL11.GL_FLOAT -> Float.BYTES
            GL11.GL_2_BYTES -> Vec2b.size
            GL11.GL_3_BYTES -> Vec3b.size
            GL11.GL_4_BYTES -> Vec4b.size
            GL11.GL_DOUBLE -> Double.BYTES
            else -> throw Exception("[DataType::size] Invalid value")
        }
}

//###############################################################################

//ListNameType enum:
//use DataType BYTE
//use DataType UNSIGNED_BYTE
//use DataType SHORT
//use DataType UNSIGNED_SHORT
//use DataType INT
//use DataType UNSIGNED_INT
//use DataType FLOAT
//use DataType 2_BYTES
//use DataType 3_BYTES
//use DataType 4_BYTES
//
//###############################################################################
//
//ListParameterName enum:
//use SGIX_list_priority LIST_PRIORITY_SGIX
//
//###############################################################################

@JvmInline
value class LogicOp(val i: Int) {
    companion object {
        val DISABLED = LogicOp(GL11.GL_FALSE)
        val CLEAR = LogicOp(GL11.GL_CLEAR)
        val AND = LogicOp(GL11.GL_AND)
        val AND_REVERSE = LogicOp(GL11.GL_AND_REVERSE)
        val COPY = LogicOp(GL11.GL_COPY)
        val AND_INVERTED = LogicOp(GL11.GL_AND_INVERTED)
        val NOOP = LogicOp(GL11.GL_NOOP)
        val XOR = LogicOp(GL11.GL_XOR)
        val OR = LogicOp(GL11.GL_OR)
        val NOR = LogicOp(GL11.GL_NOR)
        val EQUIV = LogicOp(GL11.GL_EQUIV)
        val INVERT = LogicOp(GL11.GL_INVERT)
        val OR_REVERSE = LogicOp(GL11.GL_OR_REVERSE)
        val COPY_INVERTED = LogicOp(GL11.GL_COPY_INVERTED)
        val OR_INVERTED = LogicOp(GL11.GL_OR_INVERTED)
        val NAND = LogicOp(GL11.GL_NAND)
        val SET = LogicOp(GL11.GL_SET)
    }
}

//###############################################################################
//
//MapTarget enum:
//use GetPName MAP1_COLOR_4
//use GetPName MAP1_INDEX
//use GetPName MAP1_NORMAL
//use GetPName MAP1_TEXTURE_COORD_1
//use GetPName MAP1_TEXTURE_COORD_2
//use GetPName MAP1_TEXTURE_COORD_3
//use GetPName MAP1_TEXTURE_COORD_4
//use GetPName MAP1_VERTEX_3
//use GetPName MAP1_VERTEX_4
//use GetPName MAP2_COLOR_4
//use GetPName MAP2_INDEX
//use GetPName MAP2_NORMAL
//use GetPName MAP2_TEXTURE_COORD_1
//use GetPName MAP2_TEXTURE_COORD_2
//use GetPName MAP2_TEXTURE_COORD_3
//use GetPName MAP2_TEXTURE_COORD_4
//use GetPName MAP2_VERTEX_3
//use GetPName MAP2_VERTEX_4
//use SGIX_polynomial_ffd GEOMETRY_DEFORMATION_SGIX
//use SGIX_polynomial_ffd TEXTURE_DEFORMATION_SGIX
//
//###############################################################################
//
//MaterialFace enum:
//use DrawBufferMode FRONT
//use DrawBufferMode BACK
//use DrawBufferMode FRONT_AND_BACK
//
//
//###############################################################################
//
//MaterialParameter enum:
//EMISSION					= 0x1600
//SHININESS					= 0x1601
//AMBIENT_AND_DIFFUSE				= 0x1602
//COLOR_INDEXES					= 0x1603
//use LightProperty AMBIENT
//use LightProperty DIFFUSE
//use LightProperty SPECULAR
//
//###############################################################################
//
//MatrixMode enum:
//MODELVIEW					= 0x1700
//PROJECTION					= 0x1701
//TEXTURE						= 0x1702
//
//###############################################################################
//
//MeshMode1 enum:
//use PolygonMode POINT
//use PolygonMode LINE
//
//###############################################################################
//
//MeshMode2 enum:
//use PolygonMode POINT
//use PolygonMode LINE
//use PolygonMode FILL
//
//###############################################################################
//
//MinmaxTargetEXT enum:
//use EXT_histogram MINMAX_EXT
//
//###############################################################################
//
//NormalPointerType enum:
//use DataType BYTE
//use DataType SHORT
//use DataType INT
//use DataType FLOAT
//use DataType DOUBLE
//
//###############################################################################

@JvmInline
value class BufferType(val i: Int) {
    companion object {
        val COLOR = BufferType(GL11.GL_COLOR)
        val DEPTH = BufferType(GL11C.GL_DEPTH)
        val STENCIL = BufferType(GL11.GL_STENCIL)
        val DEPTH_STENCIL = BufferType(GL30C.GL_DEPTH_STENCIL)
    }
}

//###############################################################################
//
//PixelFormat enum:
//COLOR_INDEX					= 0x1900
//STENCIL_INDEX					= 0x1901
//DEPTH_COMPONENT					= 0x1902
//RED						= 0x1903
//GREEN						= 0x1904
//BLUE						= 0x1905
//ALPHA						= 0x1906
//RGB						= 0x1907
//RGBA						= 0x1908
//LUMINANCE					= 0x1909
//LUMINANCE_ALPHA					= 0x190A
//use EXT_abgr ABGR_EXT
//use EXT_cmyka CMYK_EXT
//use EXT_cmyka CMYKA_EXT
//use SGIX_icc_texture R5_G6_B5_ICC_SGIX
//use SGIX_icc_texture R5_G6_B5_A8_ICC_SGIX
//use SGIX_icc_texture ALPHA16_ICC_SGIX
//use SGIX_icc_texture LUMINANCE16_ICC_SGIX
//use SGIX_icc_texture LUMINANCE16_ALPHA8_ICC_SGIX
//use SGIX_ycrcb YCRCB_422_SGIX
//use SGIX_ycrcb YCRCB_444_SGIX
//
//###############################################################################
//
//PixelMap enum:
//use GetPixelMap PIXEL_MAP_I_TO_I
//use GetPixelMap PIXEL_MAP_S_TO_S
//use GetPixelMap PIXEL_MAP_I_TO_R
//use GetPixelMap PIXEL_MAP_I_TO_G
//use GetPixelMap PIXEL_MAP_I_TO_B
//use GetPixelMap PIXEL_MAP_I_TO_A
//use GetPixelMap PIXEL_MAP_R_TO_R
//use GetPixelMap PIXEL_MAP_G_TO_G
//use GetPixelMap PIXEL_MAP_B_TO_B
//use GetPixelMap PIXEL_MAP_A_TO_A
//
//###############################################################################

@JvmInline
value class PixelStoreParameter(val i: Int) {
    companion object {
        val UNPACK_SWAP_BYTES = PixelStoreParameter(GL11.GL_UNPACK_SWAP_BYTES)
        val UNPACK_LSB_FIRST = PixelStoreParameter(GL11.GL_UNPACK_LSB_FIRST)
        val UNPACK_ROW_LENGTH = PixelStoreParameter(GL11.GL_UNPACK_ROW_LENGTH)
        val UNPACK_SKIP_ROWS = PixelStoreParameter(GL11.GL_UNPACK_SKIP_ROWS)
        val UNPACK_SKIP_PIXELS = PixelStoreParameter(GL11.GL_UNPACK_SKIP_PIXELS)
        val UNPACK_ALIGNMENT = PixelStoreParameter(GL11.GL_UNPACK_ALIGNMENT)
        val UNPACK_SKIP_IMAGES = PixelStoreParameter(GL12.GL_UNPACK_SKIP_IMAGES)
        val UNPACK_IMAGE_HEIGHT = PixelStoreParameter(GL12.GL_UNPACK_IMAGE_HEIGHT)
        val PACK_SWAP_BYTES = PixelStoreParameter(GL11.GL_PACK_SWAP_BYTES)
        val PACK_LSB_FIRST = PixelStoreParameter(GL11.GL_PACK_LSB_FIRST)
        val PACK_ROW_LENGTH = PixelStoreParameter(GL11.GL_PACK_ROW_LENGTH)
        val PACK_SKIP_ROWS = PixelStoreParameter(GL11.GL_PACK_SKIP_ROWS)
        val PACK_SKIP_PIXELS = PixelStoreParameter(GL11.GL_PACK_SKIP_PIXELS)
        val PACK_ALIGNMENT = PixelStoreParameter(GL11.GL_PACK_ALIGNMENT)
        val PACK_SKIP_IMAGES = PixelStoreParameter(GL12.GL_PACK_SKIP_IMAGES)
        val PACK_IMAGE_HEIGHT = PixelStoreParameter(GL12.GL_PACK_IMAGE_HEIGHT)
    }
}

//###############################################################################
//
//PixelStoreResampleMode enum:
//use SGIX_resample RESAMPLE_REPLICATE_SGIX
//use SGIX_resample RESAMPLE_ZERO_FILL_SGIX
//use SGIX_resample RESAMPLE_DECIMATE_SGIX
//
//###############################################################################
//
//PixelStoreSubsampleRate enum:
//use SGIX_subsample PIXEL_SUBSAMPLE_4444_SGIX
//use SGIX_subsample PIXEL_SUBSAMPLE_2424_SGIX
//use SGIX_subsample PIXEL_SUBSAMPLE_4242_SGIX
//
//###############################################################################
//
//PixelTexGenMode enum:
//use DrawBufferMode NONE
//use PixelFormat RGB
//use PixelFormat RGBA
//use PixelFormat LUMINANCE
//use PixelFormat LUMINANCE_ALPHA
//use SGIX_impact_pixel_texture PIXEL_TEX_GEN_ALPHA_REPLACE_SGIX
//use SGIX_impact_pixel_texture PIXEL_TEX_GEN_ALPHA_NO_REPLACE_SGIX
//use SGIX_impact_pixel_texture PIXEL_TEX_GEN_ALPHA_MS_SGIX
//use SGIX_impact_pixel_texture PIXEL_TEX_GEN_ALPHA_LS_SGIX
//
//###############################################################################
//
//PixelTexGenParameterNameSGIS enum:
//use SGIS_pixel_texture PIXEL_FRAGMENT_RGB_SOURCE_SGIS
//use SGIS_pixel_texture PIXEL_FRAGMENT_ALPHA_SOURCE_SGIS
//
//###############################################################################
//
//PixelTransferParameter enum:
//use GetPName MAP_COLOR
//use GetPName MAP_STENCIL
//use GetPName INDEX_SHIFT
//use GetPName INDEX_OFFSET
//use GetPName RED_SCALE
//use GetPName RED_BIAS
//use GetPName GREEN_SCALE
//use GetPName GREEN_BIAS
//use GetPName BLUE_SCALE
//use GetPName BLUE_BIAS
//use GetPName ALPHA_SCALE
//use GetPName ALPHA_BIAS
//use GetPName DEPTH_SCALE
//use GetPName DEPTH_BIAS
//use EXT_convolution POST_CONVOLUTION_RED_SCALE_EXT
//use EXT_convolution POST_CONVOLUTION_GREEN_SCALE_EXT
//use EXT_convolution POST_CONVOLUTION_BLUE_SCALE_EXT
//use EXT_convolution POST_CONVOLUTION_ALPHA_SCALE_EXT
//use EXT_convolution POST_CONVOLUTION_RED_BIAS_EXT
//use EXT_convolution POST_CONVOLUTION_GREEN_BIAS_EXT
//use EXT_convolution POST_CONVOLUTION_BLUE_BIAS_EXT
//use EXT_convolution POST_CONVOLUTION_ALPHA_BIAS_EXT
//use SGI_color_matrix POST_COLOR_MATRIX_RED_SCALE_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_GREEN_SCALE_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_BLUE_SCALE_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_ALPHA_SCALE_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_RED_BIAS_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_GREEN_BIAS_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_BLUE_BIAS_SGI
//use SGI_color_matrix POST_COLOR_MATRIX_ALPHA_BIAS_SGI
//
//###############################################################################
//
//PixelType enum:
//BITMAP						= 0x1A00
//use DataType BYTE
//use DataType UNSIGNED_BYTE
//use DataType SHORT
//use DataType UNSIGNED_SHORT
//use DataType INT
//use DataType UNSIGNED_INT
//use DataType FLOAT
//use EXT_packed_pixels UNSIGNED_BYTE_3_3_2_EXT
//use EXT_packed_pixels UNSIGNED_SHORT_4_4_4_4_EXT
//use EXT_packed_pixels UNSIGNED_SHORT_5_5_5_1_EXT
//use EXT_packed_pixels UNSIGNED_INT_8_8_8_8_EXT
//use EXT_packed_pixels UNSIGNED_INT_10_10_10_2_EXT
//
//###############################################################################
//
//PointParameterNameSGIS enum:
//use SGIS_point_parameters POINT_SIZE_MIN_SGIS
//use SGIS_point_parameters POINT_SIZE_MAX_SGIS
//use SGIS_point_parameters POINT_FADE_THRESHOLD_SIZE_SGIS
//use SGIS_point_parameters DISTANCE_ATTENUATION_SGIS
//
//###############################################################################

@JvmInline
value class PolygonMode(val i: Int) {
    companion object {
        val POINT = PolygonMode(GL11.GL_POINT)
        val LINE = PolygonMode(GL11.GL_LINE)
        val FILL = PolygonMode(GL11.GL_FILL)
    }
}

//###############################################################################

//inline class ReadBufferMode(val i: Int)
//use DrawBufferMode FRONT_LEFT
//use DrawBufferMode FRONT_RIGHT
//use DrawBufferMode BACK_LEFT
//use DrawBufferMode BACK_RIGHT
//use DrawBufferMode FRONT
//use DrawBufferMode BACK
//use DrawBufferMode LEFT
//use DrawBufferMode RIGHT
//use DrawBufferMode AUX0
//use DrawBufferMode AUX1
//use DrawBufferMode AUX2
//use DrawBufferMode AUX3

//###############################################################################
//
//RenderingMode enum:
//RENDER						= 0x1C00
//FEEDBACK					= 0x1C01
//SELECT						= 0x1C02
//
//###############################################################################
//
//SamplePatternSGIS enum:
//use SGIS_multisample 1PASS_SGIS
//use SGIS_multisample 2PASS_0_SGIS
//use SGIS_multisample 2PASS_1_SGIS
//use SGIS_multisample 4PASS_0_SGIS
//use SGIS_multisample 4PASS_1_SGIS
//use SGIS_multisample 4PASS_2_SGIS
//use SGIS_multisample 4PASS_3_SGIS
//
//###############################################################################
//
//SeparableTargetEXT enum:
//use EXT_convolution SEPARABLE_2D_EXT
//
//###############################################################################
//
//ShadingModel enum:
//FLAT						= 0x1D00
//SMOOTH						= 0x1D01
//
//###############################################################################
//
//StencilFunction enum:
//use AlphaFunction NEVER
//use AlphaFunction LESS
//use AlphaFunction EQUAL
//use AlphaFunction LEQUAL
//use AlphaFunction GREATER
//use AlphaFunction NOTEQUAL
//use AlphaFunction GEQUAL
//use AlphaFunction ALWAYS
//
//###############################################################################

@JvmInline
value class StencilOp(val i: Int) {
    companion object {
        val ZERO = StencilOp(GL11.GL_ZERO)
        val KEEP = StencilOp(GL11.GL_KEEP)
        val REPLACE = StencilOp(GL11.GL_REPLACE)
        val INCR = StencilOp(GL11.GL_INCR)
        val INCR_WRAP = StencilOp(GL14.GL_INCR_WRAP)
        val DECR = StencilOp(GL11.GL_DECR)
        val DECR_WRAP = StencilOp(GL14.GL_DECR_WRAP)
        val INVERT = StencilOp(GL11.GL_INVERT)
    }
}

//###############################################################################
//
//StringName enum:
//VENDOR						= 0x1F00
//RENDERER					= 0x1F01
//VERSION						= 0x1F02
//EXTENSIONS					= 0x1F03
//
//###############################################################################
//
//TexCoordPointerType enum:
//use DataType SHORT
//use DataType INT
//use DataType FLOAT
//use DataType DOUBLE
//
//###############################################################################
//
//TextureCoordName enum:
//S						= 0x2000
//T						= 0x2001
//R						= 0x2002
//Q						= 0x2003
//
//###############################################################################
//
//TextureEnvMode enum:
//MODULATE					= 0x2100
//DECAL						= 0x2101
//use GetPName BLEND
//use EXT_texture REPLACE_EXT
//use AccumOp ADD
//use SGIX_texture_add_env TEXTURE_ENV_BIAS_SGIX
//
//###############################################################################
//
//TextureEnvParameter enum:
//TEXTURE_ENV_MODE				= 0x2200
//TEXTURE_ENV_COLOR				= 0x2201
//
//###############################################################################
//
//TextureEnvTarget enum:
//TEXTURE_ENV					= 0x2300
//
//###############################################################################
//
//TextureFilterFuncSGIS enum:
//use SGIS_texture_filter4 FILTER4_SGIS
//
//###############################################################################
//
//TextureGenMode enum:
//EYE_LINEAR					= 0x2400
//OBJECT_LINEAR					= 0x2401
//SPHERE_MAP					= 0x2402
//use SGIS_point_line_texgen EYE_DISTANCE_TO_POINT_SGIS
//use SGIS_point_line_texgen OBJECT_DISTANCE_TO_POINT_SGIS
//use SGIS_point_line_texgen EYE_DISTANCE_TO_LINE_SGIS
//use SGIS_point_line_texgen OBJECT_DISTANCE_TO_LINE_SGIS
//
//###############################################################################
//
//TextureGenParameter enum:
//TEXTURE_GEN_MODE				= 0x2500
//OBJECT_PLANE					= 0x2501
//EYE_PLANE					= 0x2502
//use SGIS_point_line_texgen EYE_POINT_SGIS
//use SGIS_point_line_texgen OBJECT_POINT_SGIS
//use SGIS_point_line_texgen EYE_LINE_SGIS
//use SGIS_point_line_texgen OBJECT_LINE_SGIS
//
//###############################################################################

@JvmInline
value class MagFilter(val i: Int) {
    companion object {
        val NEAREST = MagFilter(GL11.GL_NEAREST)
        val LINEAR = MagFilter(GL11.GL_LINEAR)
    }
}

//###############################################################################

@JvmInline
value class MinFilter(val i: Int) {
    companion object {
        val NEAREST = MinFilter(GL11.GL_NEAREST)
        val LINEAR = MinFilter(GL11.GL_LINEAR)
        val NEAREST_MIPMAP_NEAREST = MinFilter(GL11.GL_NEAREST_MIPMAP_NEAREST)
        val LINEAR_MIPMAP_NEAREST = MinFilter(GL11.GL_LINEAR_MIPMAP_NEAREST)
        val NEAREST_MIPMAP_LINEAR = MinFilter(GL11.GL_NEAREST_MIPMAP_LINEAR)
        val LINEAR_MIPMAP_LINEAR = MinFilter(GL11.GL_LINEAR_MIPMAP_LINEAR)
    }
}

//###############################################################################
//
//TextureParameterName enum:
//TEXTURE_MAG_FILTER				= 0x2800
//TEXTURE_MIN_FILTER				= 0x2801
//TEXTURE_WRAP_S					= 0x2802
//TEXTURE_WRAP_T					= 0x2803
//use GetTextureParameter TEXTURE_BORDER_COLOR
//use GetTextureParameter TEXTURE_PRIORITY
//use EXT_texture3D TEXTURE_WRAP_R_EXT
//use SGIS_detail_texture DETAIL_TEXTURE_LEVEL_SGIS
//use SGIS_detail_texture DETAIL_TEXTURE_MODE_SGIS
//use SGIS_generate_mipmap GENERATE_MIPMAP_SGIS
//use SGIS_texture_select DUAL_TEXTURE_SELECT_SGIS
//use SGIS_texture_select QUAD_TEXTURE_SELECT_SGIS
//use SGIS_texture4D TEXTURE_WRAP_Q_SGIS
//use SGIX_clipmap TEXTURE_CLIPMAP_CENTER_SGIX
//use SGIX_clipmap TEXTURE_CLIPMAP_FRAME_SGIX
//use SGIX_clipmap TEXTURE_CLIPMAP_OFFSET_SGIX
//use SGIX_clipmap TEXTURE_CLIPMAP_VIRTUAL_DEPTH_SGIX
//use SGIX_clipmap TEXTURE_CLIPMAP_LOD_OFFSET_SGIX
//use SGIX_clipmap TEXTURE_CLIPMAP_DEPTH_SGIX
//use SGIX_shadow TEXTURE_COMPARE_SGIX
//use SGIX_shadow TEXTURE_COMPARE_OPERATOR_SGIX
//use SGIX_shadow_ambient SHADOW_AMBIENT_SGIX
//use SGIX_texture_coordinate_clamp TEXTURE_MAX_CLAMP_S_SGIX
//use SGIX_texture_coordinate_clamp TEXTURE_MAX_CLAMP_T_SGIX
//use SGIX_texture_coordinate_clamp TEXTURE_MAX_CLAMP_R_SGIX
//use SGIX_texture_lod_bias TEXTURE_LOD_BIAS_S_SGIX
//use SGIX_texture_lod_bias TEXTURE_LOD_BIAS_T_SGIX
//use SGIX_texture_lod_bias TEXTURE_LOD_BIAS_R_SGIX
//use SGIX_texture_scale_bias POST_TEXTURE_FILTER_BIAS_SGIX
//use SGIX_texture_scale_bias POST_TEXTURE_FILTER_SCALE_SGIX
//
//###############################################################################

@JvmInline
value class TextureTarget(val i: Int) {
    companion object {
        val _1D = TextureTarget(GL11.GL_TEXTURE_1D)
        val _2D = TextureTarget(GL11.GL_TEXTURE_2D)
        val _3D = TextureTarget(GL12.GL_TEXTURE_3D)
        val _1D_ARRAY = TextureTarget(GL30.GL_TEXTURE_1D_ARRAY)
        val _2D_ARRAY = TextureTarget(GL30.GL_TEXTURE_2D_ARRAY)
        val RECTANGLE = TextureTarget(GL31.GL_TEXTURE_RECTANGLE)
        val _2D_MULTISAMPLE = TextureTarget(GL32C.GL_TEXTURE_2D_MULTISAMPLE)
        val _2D_MULTISAMPLE_ARRAY = TextureTarget(GL32.GL_TEXTURE_2D_MULTISAMPLE_ARRAY)
        val CUBE_MAP = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP)
        val CUBE_MAP_POSITIVE_X = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_X)
        val CUBE_MAP_MEGATIVE_X = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_X)
        val CUBE_MAP_POSITIVE_Y = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Y)
        val CUBE_MAP_MEGATIVE_Y = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y)
        val CUBE_MAP_POSITIVE_Z = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Z)
        val CUBE_MAP_MEGATIVE_Z = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z)
        val PROXY_1D = TextureTarget(GL11.GL_PROXY_TEXTURE_1D)
        val PROXY_2D = TextureTarget(GL11.GL_PROXY_TEXTURE_2D)
        val PROXY_3D = TextureTarget(GL12.GL_PROXY_TEXTURE_3D)
        val PROXY_1D_ARRAY = TextureTarget(GL30.GL_PROXY_TEXTURE_1D_ARRAY)
        val PROXY_2D_ARRAY = TextureTarget(GL30.GL_PROXY_TEXTURE_2D_ARRAY)
        val PROXY_RECTANGLE = TextureTarget(GL31.GL_PROXY_TEXTURE_RECTANGLE)
        val PROXY_2D_MULTISAMPLE = TextureTarget(GL32.GL_PROXY_TEXTURE_2D_MULTISAMPLE)
        val PROXY_2D_MULTISAMPLE_ARRAY = TextureTarget(GL32.GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY)
        val PROXY_CUBE_MAP = TextureTarget(GL32.GL_PROXY_TEXTURE_CUBE_MAP)
        val BUFFER = TextureTarget(GL32.GL_TEXTURE_BUFFER)
    }
}

@JvmInline
value class Tex2dTarget(val i: Int) {
    companion object {
        val _2D = Tex2dTarget(GL11.GL_TEXTURE_2D)
        val _1D_ARRAY = Tex2dTarget(GL30.GL_TEXTURE_1D_ARRAY)
        val RECTANGLE = Tex2dTarget(GL31.GL_TEXTURE_RECTANGLE)
        val CUBE_MAP_POSITIVE_X = Tex2dTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_X)
        val CUBE_MAP_MEGATIVE_X = Tex2dTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_X)
        val CUBE_MAP_POSITIVE_Y = Tex2dTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Y)
        val CUBE_MAP_MEGATIVE_Y = Tex2dTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y)
        val CUBE_MAP_POSITIVE_Z = Tex2dTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Z)
        val CUBE_MAP_MEGATIVE_Z = Tex2dTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z)
        val PROXY_2D = Tex2dTarget(GL11.GL_PROXY_TEXTURE_2D)
        val PROXY_1D_ARRAY = Tex2dTarget(GL30.GL_PROXY_TEXTURE_1D_ARRAY)
        val PROXY_RECTANGLE = Tex2dTarget(GL31.GL_PROXY_TEXTURE_RECTANGLE)
    }
}

//###############################################################################

@JvmInline
value class TextureWrapMode(val i: Int) {
    companion object {
        val CLAMP = TextureWrapMode(GL11.GL_CLAMP)
        val REPEAT = TextureWrapMode(GL11.GL_REPEAT)
    }
}

//###############################################################################
//
//PixelInternalFormat enum:
//R3_G3_B2					= 0x2A10
//ALPHA4						= 0x803B
//ALPHA8						= 0x803C
//ALPHA12						= 0x803D
//ALPHA16						= 0x803E
//LUMINANCE4					= 0x803F
//LUMINANCE8					= 0x8040
//LUMINANCE12					= 0x8041
//LUMINANCE16					= 0x8042
//LUMINANCE4_ALPHA4				= 0x8043
//LUMINANCE6_ALPHA2				= 0x8044
//LUMINANCE8_ALPHA8				= 0x8045
//LUMINANCE12_ALPHA4				= 0x8046
//LUMINANCE12_ALPHA12				= 0x8047
//LUMINANCE16_ALPHA16				= 0x8048
//INTENSITY					= 0x8049
//INTENSITY4					= 0x804A
//INTENSITY8					= 0x804B
//INTENSITY12					= 0x804C
//INTENSITY16					= 0x804D
//RGB4						= 0x804F
//RGB5						= 0x8050
//RGB8						= 0x8051
//RGB10						= 0x8052
//RGB12						= 0x8053
//RGB16						= 0x8054
//RGBA2						= 0x8055
//RGBA4						= 0x8056
//RGB5_A1						= 0x8057
//RGBA8						= 0x8058
//RGB10_A2					= 0x8059
//RGBA12						= 0x805A
//RGBA16						= 0x805B
//use EXT_texture RGB2_EXT
//use SGIS_texture_select DUAL_ALPHA4_SGIS
//use SGIS_texture_select DUAL_ALPHA8_SGIS
//use SGIS_texture_select DUAL_ALPHA12_SGIS
//use SGIS_texture_select DUAL_ALPHA16_SGIS
//use SGIS_texture_select DUAL_LUMINANCE4_SGIS
//use SGIS_texture_select DUAL_LUMINANCE8_SGIS
//use SGIS_texture_select DUAL_LUMINANCE12_SGIS
//use SGIS_texture_select DUAL_LUMINANCE16_SGIS
//use SGIS_texture_select DUAL_INTENSITY4_SGIS
//use SGIS_texture_select DUAL_INTENSITY8_SGIS
//use SGIS_texture_select DUAL_INTENSITY12_SGIS
//use SGIS_texture_select DUAL_INTENSITY16_SGIS
//use SGIS_texture_select DUAL_LUMINANCE_ALPHA4_SGIS
//use SGIS_texture_select DUAL_LUMINANCE_ALPHA8_SGIS
//use SGIS_texture_select QUAD_ALPHA4_SGIS
//use SGIS_texture_select QUAD_ALPHA8_SGIS
//use SGIS_texture_select QUAD_LUMINANCE4_SGIS
//use SGIS_texture_select QUAD_LUMINANCE8_SGIS
//use SGIS_texture_select QUAD_INTENSITY4_SGIS
//use SGIS_texture_select QUAD_INTENSITY8_SGIS
//use SGIX_depth_texture DEPTH_COMPONENT16_SGIX
//use SGIX_depth_texture DEPTH_COMPONENT24_SGIX
//use SGIX_depth_texture DEPTH_COMPONENT32_SGIX
//use SGIX_icc_texture RGB_ICC_SGIX
//use SGIX_icc_texture RGBA_ICC_SGIX
//use SGIX_icc_texture ALPHA_ICC_SGIX
//use SGIX_icc_texture LUMINANCE_ICC_SGIX
//use SGIX_icc_texture INTENSITY_ICC_SGIX
//use SGIX_icc_texture LUMINANCE_ALPHA_ICC_SGIX
//use SGIX_icc_texture R5_G6_B5_ICC_SGIX
//use SGIX_icc_texture R5_G6_B5_A8_ICC_SGIX
//use SGIX_icc_texture ALPHA16_ICC_SGIX
//use SGIX_icc_texture LUMINANCE16_ICC_SGIX
//use SGIX_icc_texture INTENSITY16_ICC_SGIX
//use SGIX_icc_texture LUMINANCE16_ALPHA8_ICC_SGIX
//
//###############################################################################
//
//InterleavedArrayFormat enum:
//V2F						= 0x2A20
//V3F						= 0x2A21
//C4UB_V2F					= 0x2A22
//C4UB_V3F					= 0x2A23
//C3F_V3F						= 0x2A24
//N3F_V3F						= 0x2A25
//C4F_N3F_V3F					= 0x2A26
//T2F_V3F						= 0x2A27
//T4F_V4F						= 0x2A28
//T2F_C4UB_V3F					= 0x2A29
//T2F_C3F_V3F					= 0x2A2A
//T2F_N3F_V3F					= 0x2A2B
//T2F_C4F_N3F_V3F					= 0x2A2C
//T4F_C4F_N3F_V4F					= 0x2A2D
//
//###############################################################################
//
//VertexPointerType enum:
//use DataType SHORT
//use DataType INT
//use DataType FLOAT
//use DataType DOUBLE
//
//###############################################################################
//
//# 0x3000 through 0x3FFF are reserved for clip planes
//ClipPlaneName enum:
//CLIP_PLANE0					= 0x3000 # 1 I
//CLIP_PLANE1					= 0x3001 # 1 I
//CLIP_PLANE2					= 0x3002 # 1 I
//CLIP_PLANE3					= 0x3003 # 1 I
//CLIP_PLANE4					= 0x3004 # 1 I
//CLIP_PLANE5					= 0x3005 # 1 I
//
//# VERSION_3_0 enum: (aliases)
//#	CLIP_DISTANCE0					= GL_CLIP_PLANE0    # 3.0
//#	CLIP_DISTANCE1					= GL_CLIP_PLANE1    # 3.0
//#	CLIP_DISTANCE2					= GL_CLIP_PLANE2    # 3.0
//#	CLIP_DISTANCE3					= GL_CLIP_PLANE3    # 3.0
//#	CLIP_DISTANCE4					= GL_CLIP_PLANE4    # 3.0
//#	CLIP_DISTANCE5					= GL_CLIP_PLANE5    # 3.0
//
//###############################################################################
//
//# 0x4000-0x4FFF are reserved for light numbers
//LightName enum:
//LIGHT0						= 0x4000 # 1 I
//LIGHT1						= 0x4001 # 1 I
//LIGHT2						= 0x4002 # 1 I
//LIGHT3						= 0x4003 # 1 I
//LIGHT4						= 0x4004 # 1 I
//LIGHT5						= 0x4005 # 1 I
//LIGHT6						= 0x4006 # 1 I
//LIGHT7						= 0x4007 # 1 I
//use SGIX_fragment_lighting FRAGMENT_LIGHT0_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT1_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT2_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT3_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT4_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT5_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT6_SGIX
//use SGIX_fragment_lighting FRAGMENT_LIGHT7_SGIX
//
//###############################################################################
//
//EXT_abgr enum:
//ABGR_EXT					= 0x8000
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_blend_color enum:
//CONSTANT_COLOR					= 0x8001
//CONSTANT_COLOR_EXT				= 0x8001
//ONE_MINUS_CONSTANT_COLOR			= 0x8002
//ONE_MINUS_CONSTANT_COLOR_EXT			= 0x8002
//CONSTANT_ALPHA					= 0x8003
//CONSTANT_ALPHA_EXT				= 0x8003
//ONE_MINUS_CONSTANT_ALPHA			= 0x8004
//ONE_MINUS_CONSTANT_ALPHA_EXT			= 0x8004
//BLEND_COLOR					= 0x8005 # 4 F
//BLEND_COLOR_EXT					= 0x8005 # 4 F
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_blend_minmax enum:
//FUNC_ADD					= 0x8006
//FUNC_ADD_EXT					= 0x8006
//MIN						= 0x8007
//MIN_EXT						= 0x8007
//MAX						= 0x8008
//MAX_EXT						= 0x8008
//BLEND_EQUATION					= 0x8009 # 1 I
//BLEND_EQUATION_EXT				= 0x8009 # 1 I
//
//# VERSION_2_0 enum: (Promoted for OpenGL 2.0)
//# EXT_blend_equation_separate enum: (separate; see below)
//#	BLEND_EQUATION_RGB				= GL_BLEND_EQUATION # VERSION_2_0
//#	BLEND_EQUATION_RGB_EXT				= GL_BLEND_EQUATION
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_blend_subtract enum:
//FUNC_SUBTRACT					= 0x800A
//FUNC_SUBTRACT_EXT				= 0x800A
//FUNC_REVERSE_SUBTRACT				= 0x800B
//FUNC_REVERSE_SUBTRACT_EXT			= 0x800B
//
//###############################################################################
//
//EXT_cmyka enum:
//CMYK_EXT					= 0x800C
//CMYKA_EXT					= 0x800D
//PACK_CMYK_HINT_EXT				= 0x800E # 1 I
//UNPACK_CMYK_HINT_EXT				= 0x800F # 1 I
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_convolution enum:
//CONVOLUTION_1D					= 0x8010 # 1 I
//CONVOLUTION_1D_EXT				= 0x8010 # 1 I
//CONVOLUTION_2D					= 0x8011 # 1 I
//CONVOLUTION_2D_EXT				= 0x8011 # 1 I
//SEPARABLE_2D					= 0x8012 # 1 I
//SEPARABLE_2D_EXT				= 0x8012 # 1 I
//CONVOLUTION_BORDER_MODE				= 0x8013
//CONVOLUTION_BORDER_MODE_EXT			= 0x8013
//CONVOLUTION_FILTER_SCALE			= 0x8014
//CONVOLUTION_FILTER_SCALE_EXT			= 0x8014
//CONVOLUTION_FILTER_BIAS				= 0x8015
//CONVOLUTION_FILTER_BIAS_EXT			= 0x8015
//REDUCE						= 0x8016
//REDUCE_EXT					= 0x8016
//CONVOLUTION_FORMAT				= 0x8017
//CONVOLUTION_FORMAT_EXT				= 0x8017
//CONVOLUTION_WIDTH				= 0x8018
//CONVOLUTION_WIDTH_EXT				= 0x8018
//CONVOLUTION_HEIGHT				= 0x8019
//CONVOLUTION_HEIGHT_EXT				= 0x8019
//MAX_CONVOLUTION_WIDTH				= 0x801A
//MAX_CONVOLUTION_WIDTH_EXT			= 0x801A
//MAX_CONVOLUTION_HEIGHT				= 0x801B
//MAX_CONVOLUTION_HEIGHT_EXT			= 0x801B
//POST_CONVOLUTION_RED_SCALE			= 0x801C # 1 F
//POST_CONVOLUTION_RED_SCALE_EXT			= 0x801C # 1 F
//POST_CONVOLUTION_GREEN_SCALE			= 0x801D # 1 F
//POST_CONVOLUTION_GREEN_SCALE_EXT		= 0x801D # 1 F
//POST_CONVOLUTION_BLUE_SCALE			= 0x801E # 1 F
//POST_CONVOLUTION_BLUE_SCALE_EXT			= 0x801E # 1 F
//POST_CONVOLUTION_ALPHA_SCALE			= 0x801F # 1 F
//POST_CONVOLUTION_ALPHA_SCALE_EXT		= 0x801F # 1 F
//POST_CONVOLUTION_RED_BIAS			= 0x8020 # 1 F
//POST_CONVOLUTION_RED_BIAS_EXT			= 0x8020 # 1 F
//POST_CONVOLUTION_GREEN_BIAS			= 0x8021 # 1 F
//POST_CONVOLUTION_GREEN_BIAS_EXT			= 0x8021 # 1 F
//POST_CONVOLUTION_BLUE_BIAS			= 0x8022 # 1 F
//POST_CONVOLUTION_BLUE_BIAS_EXT			= 0x8022 # 1 F
//POST_CONVOLUTION_ALPHA_BIAS			= 0x8023 # 1 F
//POST_CONVOLUTION_ALPHA_BIAS_EXT			= 0x8023 # 1 F
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_histogram enum:
//HISTOGRAM					= 0x8024 # 1 I
//HISTOGRAM_EXT					= 0x8024 # 1 I
//PROXY_HISTOGRAM					= 0x8025
//PROXY_HISTOGRAM_EXT				= 0x8025
//HISTOGRAM_WIDTH					= 0x8026
//HISTOGRAM_WIDTH_EXT				= 0x8026
//HISTOGRAM_FORMAT				= 0x8027
//HISTOGRAM_FORMAT_EXT				= 0x8027
//HISTOGRAM_RED_SIZE				= 0x8028
//HISTOGRAM_RED_SIZE_EXT				= 0x8028
//HISTOGRAM_GREEN_SIZE				= 0x8029
//HISTOGRAM_GREEN_SIZE_EXT			= 0x8029
//HISTOGRAM_BLUE_SIZE				= 0x802A
//HISTOGRAM_BLUE_SIZE_EXT				= 0x802A
//HISTOGRAM_ALPHA_SIZE				= 0x802B
//HISTOGRAM_ALPHA_SIZE_EXT			= 0x802B
//HISTOGRAM_LUMINANCE_SIZE			= 0x802C
//HISTOGRAM_LUMINANCE_SIZE_EXT			= 0x802C
//HISTOGRAM_SINK					= 0x802D
//HISTOGRAM_SINK_EXT				= 0x802D
//MINMAX						= 0x802E # 1 I
//MINMAX_EXT					= 0x802E # 1 I
//MINMAX_FORMAT					= 0x802F
//MINMAX_FORMAT_EXT				= 0x802F
//MINMAX_SINK					= 0x8030
//MINMAX_SINK_EXT					= 0x8030
//TABLE_TOO_LARGE					= 0x8031
//TABLE_TOO_LARGE_EXT				= 0x8031
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_packed_pixels enum:
//UNSIGNED_BYTE_3_3_2				= 0x8032
//UNSIGNED_BYTE_3_3_2_EXT				= 0x8032
//UNSIGNED_SHORT_4_4_4_4				= 0x8033
//UNSIGNED_SHORT_4_4_4_4_EXT			= 0x8033
//UNSIGNED_SHORT_5_5_5_1				= 0x8034
//UNSIGNED_SHORT_5_5_5_1_EXT			= 0x8034
//UNSIGNED_INT_8_8_8_8				= 0x8035
//UNSIGNED_INT_8_8_8_8_EXT			= 0x8035
//UNSIGNED_INT_10_10_10_2				= 0x8036
//UNSIGNED_INT_10_10_10_2_EXT			= 0x8036
//UNSIGNED_BYTE_2_3_3_REV				= 0x8362
//UNSIGNED_BYTE_2_3_3_REV_EXT			= 0x8362
//UNSIGNED_SHORT_5_6_5				= 0x8363
//UNSIGNED_SHORT_5_6_5_EXT			= 0x8363
//UNSIGNED_SHORT_5_6_5_REV			= 0x8364
//UNSIGNED_SHORT_5_6_5_REV_EXT			= 0x8364
//UNSIGNED_SHORT_4_4_4_4_REV			= 0x8365
//UNSIGNED_SHORT_4_4_4_4_REV_EXT			= 0x8365
//UNSIGNED_SHORT_1_5_5_5_REV			= 0x8366
//UNSIGNED_SHORT_1_5_5_5_REV_EXT			= 0x8366
//UNSIGNED_INT_8_8_8_8_REV			= 0x8367
//UNSIGNED_INT_8_8_8_8_REV_EXT			= 0x8367
//UNSIGNED_INT_2_10_10_10_REV			= 0x8368
//UNSIGNED_INT_2_10_10_10_REV_EXT			= 0x8368
//
//###############################################################################
//
//EXT_polygon_offset enum:
//POLYGON_OFFSET_EXT				= 0x8037
//POLYGON_OFFSET_FACTOR_EXT			= 0x8038
//POLYGON_OFFSET_BIAS_EXT				= 0x8039 # 1 F
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_rescale_normal enum:
//RESCALE_NORMAL					= 0x803A # 1 I
//RESCALE_NORMAL_EXT				= 0x803A # 1 I
//
//###############################################################################
//
//EXT_texture enum:
//ALPHA4_EXT					= 0x803B
//ALPHA8_EXT					= 0x803C
//ALPHA12_EXT					= 0x803D
//ALPHA16_EXT					= 0x803E
//LUMINANCE4_EXT					= 0x803F
//LUMINANCE8_EXT					= 0x8040
//LUMINANCE12_EXT					= 0x8041
//LUMINANCE16_EXT					= 0x8042
//LUMINANCE4_ALPHA4_EXT				= 0x8043
//LUMINANCE6_ALPHA2_EXT				= 0x8044
//LUMINANCE8_ALPHA8_EXT				= 0x8045
//LUMINANCE12_ALPHA4_EXT				= 0x8046
//LUMINANCE12_ALPHA12_EXT				= 0x8047
//LUMINANCE16_ALPHA16_EXT				= 0x8048
//INTENSITY_EXT					= 0x8049
//INTENSITY4_EXT					= 0x804A
//INTENSITY8_EXT					= 0x804B
//INTENSITY12_EXT					= 0x804C
//INTENSITY16_EXT					= 0x804D
//RGB2_EXT					= 0x804E
//RGB4_EXT					= 0x804F
//RGB5_EXT					= 0x8050
//RGB8_EXT					= 0x8051
//RGB10_EXT					= 0x8052
//RGB12_EXT					= 0x8053
//RGB16_EXT					= 0x8054
//RGBA2_EXT					= 0x8055
//RGBA4_EXT					= 0x8056
//RGB5_A1_EXT					= 0x8057
//RGBA8_EXT					= 0x8058
//RGB10_A2_EXT					= 0x8059
//RGBA12_EXT					= 0x805A
//RGBA16_EXT					= 0x805B
//TEXTURE_RED_SIZE_EXT				= 0x805C
//TEXTURE_GREEN_SIZE_EXT				= 0x805D
//TEXTURE_BLUE_SIZE_EXT				= 0x805E
//TEXTURE_ALPHA_SIZE_EXT				= 0x805F
//TEXTURE_LUMINANCE_SIZE_EXT			= 0x8060
//TEXTURE_INTENSITY_SIZE_EXT			= 0x8061
//REPLACE_EXT					= 0x8062
//PROXY_TEXTURE_1D_EXT				= 0x8063
//PROXY_TEXTURE_2D_EXT				= 0x8064
//TEXTURE_TOO_LARGE_EXT				= 0x8065
//
//###############################################################################
//
//EXT_texture_object enum:
//TEXTURE_PRIORITY_EXT				= 0x8066
//TEXTURE_RESIDENT_EXT				= 0x8067
//TEXTURE_1D_BINDING_EXT				= 0x8068
//TEXTURE_2D_BINDING_EXT				= 0x8069
//TEXTURE_3D_BINDING_EXT				= 0x806A # 1 I
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_texture3D enum:
//PACK_SKIP_IMAGES				= 0x806B # 1 I
//PACK_SKIP_IMAGES_EXT				= 0x806B # 1 I
//PACK_IMAGE_HEIGHT				= 0x806C # 1 F
//PACK_IMAGE_HEIGHT_EXT				= 0x806C # 1 F
//UNPACK_SKIP_IMAGES				= 0x806D # 1 I
//UNPACK_SKIP_IMAGES_EXT				= 0x806D # 1 I
//UNPACK_IMAGE_HEIGHT				= 0x806E # 1 F
//UNPACK_IMAGE_HEIGHT_EXT				= 0x806E # 1 F
//TEXTURE_3D					= 0x806F # 1 I
//TEXTURE_3D_EXT					= 0x806F # 1 I
//PROXY_TEXTURE_3D				= 0x8070
//PROXY_TEXTURE_3D_EXT				= 0x8070
//TEXTURE_DEPTH					= 0x8071
//TEXTURE_DEPTH_EXT				= 0x8071
//TEXTURE_WRAP_R					= 0x8072
//TEXTURE_WRAP_R_EXT				= 0x8072
//MAX_3D_TEXTURE_SIZE				= 0x8073 # 1 I
//MAX_3D_TEXTURE_SIZE_EXT				= 0x8073 # 1 I
//
//###############################################################################
//
//EXT_vertex_array enum:
//VERTEX_ARRAY_EXT				= 0x8074
//NORMAL_ARRAY_EXT				= 0x8075
//COLOR_ARRAY_EXT					= 0x8076
//INDEX_ARRAY_EXT					= 0x8077
//TEXTURE_COORD_ARRAY_EXT				= 0x8078
//EDGE_FLAG_ARRAY_EXT				= 0x8079
//VERTEX_ARRAY_SIZE_EXT				= 0x807A
//VERTEX_ARRAY_TYPE_EXT				= 0x807B
//VERTEX_ARRAY_STRIDE_EXT				= 0x807C
//VERTEX_ARRAY_COUNT_EXT				= 0x807D # 1 I
//NORMAL_ARRAY_TYPE_EXT				= 0x807E
//NORMAL_ARRAY_STRIDE_EXT				= 0x807F
//NORMAL_ARRAY_COUNT_EXT				= 0x8080 # 1 I
//COLOR_ARRAY_SIZE_EXT				= 0x8081
//COLOR_ARRAY_TYPE_EXT				= 0x8082
//COLOR_ARRAY_STRIDE_EXT				= 0x8083
//COLOR_ARRAY_COUNT_EXT				= 0x8084 # 1 I
//INDEX_ARRAY_TYPE_EXT				= 0x8085
//INDEX_ARRAY_STRIDE_EXT				= 0x8086
//INDEX_ARRAY_COUNT_EXT				= 0x8087 # 1 I
//TEXTURE_COORD_ARRAY_SIZE_EXT			= 0x8088
//TEXTURE_COORD_ARRAY_TYPE_EXT			= 0x8089
//TEXTURE_COORD_ARRAY_STRIDE_EXT			= 0x808A
//TEXTURE_COORD_ARRAY_COUNT_EXT			= 0x808B # 1 I
//EDGE_FLAG_ARRAY_STRIDE_EXT			= 0x808C
//EDGE_FLAG_ARRAY_COUNT_EXT			= 0x808D # 1 I
//VERTEX_ARRAY_POINTER_EXT			= 0x808E
//NORMAL_ARRAY_POINTER_EXT			= 0x808F
//COLOR_ARRAY_POINTER_EXT				= 0x8090
//INDEX_ARRAY_POINTER_EXT				= 0x8091
//TEXTURE_COORD_ARRAY_POINTER_EXT			= 0x8092
//EDGE_FLAG_ARRAY_POINTER_EXT			= 0x8093
//
//###############################################################################
//
//SGIX_interlace enum:
//INTERLACE_SGIX					= 0x8094 # 1 I
//
//###############################################################################
//
//SGIS_detail_texture enum:
//DETAIL_TEXTURE_2D_SGIS				= 0x8095
//DETAIL_TEXTURE_2D_BINDING_SGIS			= 0x8096 # 1 I
//LINEAR_DETAIL_SGIS				= 0x8097
//LINEAR_DETAIL_ALPHA_SGIS			= 0x8098
//LINEAR_DETAIL_COLOR_SGIS			= 0x8099
//DETAIL_TEXTURE_LEVEL_SGIS			= 0x809A
//DETAIL_TEXTURE_MODE_SGIS			= 0x809B
//DETAIL_TEXTURE_FUNC_POINTS_SGIS			= 0x809C
//
//###############################################################################
//
//# Reuses some SGIS_multisample values
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//ARB_multisample enum:
//MULTISAMPLE					= 0x809D
//MULTISAMPLE_ARB					= 0x809D
//SAMPLE_ALPHA_TO_COVERAGE			= 0x809E
//SAMPLE_ALPHA_TO_COVERAGE_ARB			= 0x809E
//SAMPLE_ALPHA_TO_ONE				= 0x809F
//SAMPLE_ALPHA_TO_ONE_ARB				= 0x809F
//SAMPLE_COVERAGE					= 0x80A0
//SAMPLE_COVERAGE_ARB				= 0x80A0
//SAMPLE_BUFFERS					= 0x80A8 # 1 I
//SAMPLE_BUFFERS_ARB				= 0x80A8 # 1 I
//SAMPLES						= 0x80A9 # 1 I
//SAMPLES_ARB					= 0x80A9 # 1 I
//SAMPLE_COVERAGE_VALUE				= 0x80AA # 1 F
//SAMPLE_COVERAGE_VALUE_ARB			= 0x80AA # 1 F
//SAMPLE_COVERAGE_INVERT				= 0x80AB # 1 I
//SAMPLE_COVERAGE_INVERT_ARB			= 0x80AB # 1 I
//
//SGIS_multisample enum:
//MULTISAMPLE_SGIS				= 0x809D # 1 I
//SAMPLE_ALPHA_TO_MASK_SGIS			= 0x809E # 1 I
//SAMPLE_ALPHA_TO_ONE_SGIS			= 0x809F # 1 I
//SAMPLE_MASK_SGIS				= 0x80A0 # 1 I
//1PASS_SGIS					= 0x80A1
//2PASS_0_SGIS					= 0x80A2
//2PASS_1_SGIS					= 0x80A3
//4PASS_0_SGIS					= 0x80A4
//4PASS_1_SGIS					= 0x80A5
//4PASS_2_SGIS					= 0x80A6
//4PASS_3_SGIS					= 0x80A7
//SAMPLE_BUFFERS_SGIS				= 0x80A8 # 1 I
//SAMPLES_SGIS					= 0x80A9 # 1 I
//SAMPLE_MASK_VALUE_SGIS				= 0x80AA # 1 F
//SAMPLE_MASK_INVERT_SGIS				= 0x80AB # 1 I
//SAMPLE_PATTERN_SGIS				= 0x80AC # 1 I
//
//# Reuses SGIS_multisample values.
//# EXT_multisample enum:
//#	  MULTISAMPLE_EXT				  = 0x809D
//#	  SAMPLE_ALPHA_TO_MASK_EXT			  = 0x809E
//#	  SAMPLE_ALPHA_TO_ONE_EXT			  = 0x809F
//#	  SAMPLE_MASK_EXT				  = 0x80A0
//#	  1PASS_EXT					  = 0x80A1
//#	  2PASS_0_EXT					  = 0x80A2
//#	  2PASS_1_EXT					  = 0x80A3
//#	  4PASS_0_EXT					  = 0x80A4
//#	  4PASS_1_EXT					  = 0x80A5
//#	  4PASS_2_EXT					  = 0x80A6
//#	  4PASS_3_EXT					  = 0x80A7
//#	  SAMPLE_BUFFERS_EXT				  = 0x80A8 # 1 I
//#	  SAMPLES_EXT					  = 0x80A9 # 1 I
//#	  SAMPLE_MASK_VALUE_EXT				  = 0x80AA # 1 F
//#	  SAMPLE_MASK_INVERT_EXT			  = 0x80AB # 1 I
//#	  SAMPLE_PATTERN_EXT				  = 0x80AC # 1 I
//#	  MULTISAMPLE_BIT_EXT				  = 0x20000000
//
//###############################################################################
//
//SGIS_sharpen_texture enum:
//LINEAR_SHARPEN_SGIS				= 0x80AD
//LINEAR_SHARPEN_ALPHA_SGIS			= 0x80AE
//LINEAR_SHARPEN_COLOR_SGIS			= 0x80AF
//SHARPEN_TEXTURE_FUNC_POINTS_SGIS		= 0x80B0
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//SGI_color_matrix enum:
//COLOR_MATRIX					= 0x80B1 # 16 F
//COLOR_MATRIX_SGI				= 0x80B1 # 16 F
//COLOR_MATRIX_STACK_DEPTH			= 0x80B2 # 1 I
//COLOR_MATRIX_STACK_DEPTH_SGI			= 0x80B2 # 1 I
//MAX_COLOR_MATRIX_STACK_DEPTH			= 0x80B3 # 1 I
//MAX_COLOR_MATRIX_STACK_DEPTH_SGI		= 0x80B3 # 1 I
//POST_COLOR_MATRIX_RED_SCALE			= 0x80B4 # 1 F
//POST_COLOR_MATRIX_RED_SCALE_SGI			= 0x80B4 # 1 F
//POST_COLOR_MATRIX_GREEN_SCALE			= 0x80B5 # 1 F
//POST_COLOR_MATRIX_GREEN_SCALE_SGI		= 0x80B5 # 1 F
//POST_COLOR_MATRIX_BLUE_SCALE			= 0x80B6 # 1 F
//POST_COLOR_MATRIX_BLUE_SCALE_SGI		= 0x80B6 # 1 F
//POST_COLOR_MATRIX_ALPHA_SCALE			= 0x80B7 # 1 F
//POST_COLOR_MATRIX_ALPHA_SCALE_SGI		= 0x80B7 # 1 F
//POST_COLOR_MATRIX_RED_BIAS			= 0x80B8 # 1 F
//POST_COLOR_MATRIX_RED_BIAS_SGI			= 0x80B8 # 1 F
//POST_COLOR_MATRIX_GREEN_BIAS			= 0x80B9 # 1 F
//POST_COLOR_MATRIX_GREEN_BIAS_SGI		= 0x80B9 # 1 F
//POST_COLOR_MATRIX_BLUE_BIAS			= 0x80BA # 1 F
//POST_COLOR_MATRIX_BLUE_BIAS_SGI			= 0x80BA # 1 F
//POST_COLOR_MATRIX_ALPHA_BIAS			= 0x80BB # 1 F
//POST_COLOR_MATRIX_ALPHA_BIAS_SGI		= 0x80BB # 1 F
//
//###############################################################################
//
//SGI_texture_color_table enum:
//TEXTURE_COLOR_TABLE_SGI				= 0x80BC # 1 I
//PROXY_TEXTURE_COLOR_TABLE_SGI			= 0x80BD
//
//###############################################################################
//
//SGIX_texture_add_env enum:
//TEXTURE_ENV_BIAS_SGIX				= 0x80BE
//
//###############################################################################
//
//SGIX_shadow_ambient enum:
//SHADOW_AMBIENT_SGIX				= 0x80BF
//
//###############################################################################
//
//# Intergraph/Intense3D/3Dlabs: 0x80C0-0x80CF
//
//# 3Dlabs_future_use: 0x80C0-0x80C7
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# EXT_blend_func_separate enum:
//#	BLEND_DST_RGB					= 0x80C8
//#	BLEND_DST_RGB_EXT				= 0x80C8
//#	BLEND_SRC_RGB					= 0x80C9
//#	BLEND_SRC_RGB_EXT				= 0x80C9
//#	BLEND_DST_ALPHA					= 0x80CA
//#	BLEND_DST_ALPHA_EXT				= 0x80CA
//#	BLEND_SRC_ALPHA					= 0x80CB
//#	BLEND_SRC_ALPHA_EXT				= 0x80CB
//
//# EXT_422_pixels enum:
//#	422_EXT						= 0x80CC
//#	422_REV_EXT					= 0x80CD
//#	422_AVERAGE_EXT					= 0x80CE
//#	422_REV_AVERAGE_EXT				= 0x80CF
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//SGI_color_table enum:
//COLOR_TABLE					= 0x80D0 # 1 I
//COLOR_TABLE_SGI					= 0x80D0 # 1 I
//POST_CONVOLUTION_COLOR_TABLE			= 0x80D1 # 1 I
//POST_CONVOLUTION_COLOR_TABLE_SGI		= 0x80D1 # 1 I
//POST_COLOR_MATRIX_COLOR_TABLE			= 0x80D2 # 1 I
//POST_COLOR_MATRIX_COLOR_TABLE_SGI		= 0x80D2 # 1 I
//PROXY_COLOR_TABLE				= 0x80D3
//PROXY_COLOR_TABLE_SGI				= 0x80D3
//PROXY_POST_CONVOLUTION_COLOR_TABLE		= 0x80D4
//PROXY_POST_CONVOLUTION_COLOR_TABLE_SGI		= 0x80D4
//PROXY_POST_COLOR_MATRIX_COLOR_TABLE		= 0x80D5
//PROXY_POST_COLOR_MATRIX_COLOR_TABLE_SGI		= 0x80D5
//COLOR_TABLE_SCALE				= 0x80D6
//COLOR_TABLE_SCALE_SGI				= 0x80D6
//COLOR_TABLE_BIAS				= 0x80D7
//COLOR_TABLE_BIAS_SGI				= 0x80D7
//COLOR_TABLE_FORMAT				= 0x80D8
//COLOR_TABLE_FORMAT_SGI				= 0x80D8
//COLOR_TABLE_WIDTH				= 0x80D9
//COLOR_TABLE_WIDTH_SGI				= 0x80D9
//COLOR_TABLE_RED_SIZE				= 0x80DA
//COLOR_TABLE_RED_SIZE_SGI			= 0x80DA
//COLOR_TABLE_GREEN_SIZE				= 0x80DB
//COLOR_TABLE_GREEN_SIZE_SGI			= 0x80DB
//COLOR_TABLE_BLUE_SIZE				= 0x80DC
//COLOR_TABLE_BLUE_SIZE_SGI			= 0x80DC
//COLOR_TABLE_ALPHA_SIZE				= 0x80DD
//COLOR_TABLE_ALPHA_SIZE_SGI			= 0x80DD
//COLOR_TABLE_LUMINANCE_SIZE			= 0x80DE
//COLOR_TABLE_LUMINANCE_SIZE_SGI			= 0x80DE
//COLOR_TABLE_INTENSITY_SIZE			= 0x80DF
//COLOR_TABLE_INTENSITY_SIZE_SGI			= 0x80DF
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_bgra enum:
//BGR						= 0x80E0
//BGR_EXT						= 0x80E0
//BGRA						= 0x80E1
//BGRA_EXT					= 0x80E1
//
//###############################################################################
//
//# Microsoft: 0x80E2-0x80E7
//
//###############################################################################
//
//VERSION_1_2 enum:
//MAX_ELEMENTS_VERTICES				= 0x80E8
//MAX_ELEMENTS_INDICES				= 0x80E9
//
//###############################################################################
//
//# Microsoft: 0x80EA-0x810F
//
//###############################################################################
//
//SGIS_texture_select enum:
//DUAL_ALPHA4_SGIS				= 0x8110
//DUAL_ALPHA8_SGIS				= 0x8111
//DUAL_ALPHA12_SGIS				= 0x8112
//DUAL_ALPHA16_SGIS				= 0x8113
//DUAL_LUMINANCE4_SGIS				= 0x8114
//DUAL_LUMINANCE8_SGIS				= 0x8115
//DUAL_LUMINANCE12_SGIS				= 0x8116
//DUAL_LUMINANCE16_SGIS				= 0x8117
//DUAL_INTENSITY4_SGIS				= 0x8118
//DUAL_INTENSITY8_SGIS				= 0x8119
//DUAL_INTENSITY12_SGIS				= 0x811A
//DUAL_INTENSITY16_SGIS				= 0x811B
//DUAL_LUMINANCE_ALPHA4_SGIS			= 0x811C
//DUAL_LUMINANCE_ALPHA8_SGIS			= 0x811D
//QUAD_ALPHA4_SGIS				= 0x811E
//QUAD_ALPHA8_SGIS				= 0x811F
//QUAD_LUMINANCE4_SGIS				= 0x8120
//QUAD_LUMINANCE8_SGIS				= 0x8121
//QUAD_INTENSITY4_SGIS				= 0x8122
//QUAD_INTENSITY8_SGIS				= 0x8123
//DUAL_TEXTURE_SELECT_SGIS			= 0x8124
//QUAD_TEXTURE_SELECT_SGIS			= 0x8125
//
//###############################################################################
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# ARB_point_parameters enum:
//# EXT_point_parameters enum:
//SGIS_point_parameters enum:
//POINT_SIZE_MIN					= 0x8126 # 1 F
//POINT_SIZE_MIN_ARB				= 0x8126 # 1 F
//POINT_SIZE_MIN_EXT				= 0x8126 # 1 F
//POINT_SIZE_MIN_SGIS				= 0x8126 # 1 F
//POINT_SIZE_MAX					= 0x8127 # 1 F
//POINT_SIZE_MAX_ARB				= 0x8127 # 1 F
//POINT_SIZE_MAX_EXT				= 0x8127 # 1 F
//POINT_SIZE_MAX_SGIS				= 0x8127 # 1 F
//POINT_FADE_THRESHOLD_SIZE			= 0x8128 # 1 F
//POINT_FADE_THRESHOLD_SIZE_ARB			= 0x8128 # 1 F
//POINT_FADE_THRESHOLD_SIZE_EXT			= 0x8128 # 1 F
//POINT_FADE_THRESHOLD_SIZE_SGIS			= 0x8128 # 1 F
//POINT_DISTANCE_ATTENUATION			= 0x8129 # 3 F
//POINT_DISTANCE_ATTENUATION_ARB			= 0x8129 # 3 F
//DISTANCE_ATTENUATION_EXT			= 0x8129 # 3 F
//DISTANCE_ATTENUATION_SGIS			= 0x8129 # 3 F
//
//###############################################################################
//
//SGIS_fog_function enum:
//FOG_FUNC_SGIS					= 0x812A
//FOG_FUNC_POINTS_SGIS				= 0x812B # 1 I
//MAX_FOG_FUNC_POINTS_SGIS			= 0x812C # 1 I
//
//###############################################################################
//
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//# ARB_texture_border_clamp enum:
//SGIS_texture_border_clamp enum:
//CLAMP_TO_BORDER					= 0x812D
//CLAMP_TO_BORDER_ARB				= 0x812D
//CLAMP_TO_BORDER_SGIS				= 0x812D
//
//###############################################################################
//
//SGIX_texture_multi_buffer enum:
//TEXTURE_MULTI_BUFFER_HINT_SGIX			= 0x812E
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//SGIS_texture_edge_clamp enum:
//CLAMP_TO_EDGE					= 0x812F
//CLAMP_TO_EDGE_SGIS				= 0x812F
//
//###############################################################################
//
//SGIS_texture4D enum:
//PACK_SKIP_VOLUMES_SGIS				= 0x8130 # 1 I
//PACK_IMAGE_DEPTH_SGIS				= 0x8131 # 1 I
//UNPACK_SKIP_VOLUMES_SGIS			= 0x8132 # 1 I
//UNPACK_IMAGE_DEPTH_SGIS				= 0x8133 # 1 I
//TEXTURE_4D_SGIS					= 0x8134 # 1 I
//PROXY_TEXTURE_4D_SGIS				= 0x8135
//TEXTURE_4DSIZE_SGIS				= 0x8136
//TEXTURE_WRAP_Q_SGIS				= 0x8137
//MAX_4D_TEXTURE_SIZE_SGIS			= 0x8138 # 1 I
//TEXTURE_4D_BINDING_SGIS				= 0x814F # 1 I
//
//###############################################################################
//
//SGIX_pixel_texture enum:
//PIXEL_TEX_GEN_SGIX				= 0x8139 # 1 I
//PIXEL_TEX_GEN_MODE_SGIX				= 0x832B # 1 I
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//SGIS_texture_lod enum:
//TEXTURE_MIN_LOD					= 0x813A
//TEXTURE_MIN_LOD_SGIS				= 0x813A
//TEXTURE_MAX_LOD					= 0x813B
//TEXTURE_MAX_LOD_SGIS				= 0x813B
//TEXTURE_BASE_LEVEL				= 0x813C
//TEXTURE_BASE_LEVEL_SGIS				= 0x813C
//TEXTURE_MAX_LEVEL				= 0x813D
//TEXTURE_MAX_LEVEL_SGIS				= 0x813D
//
//###############################################################################
//
//SGIX_pixel_tiles enum:
//PIXEL_TILE_BEST_ALIGNMENT_SGIX			= 0x813E # 1 I
//PIXEL_TILE_CACHE_INCREMENT_SGIX			= 0x813F # 1 I
//PIXEL_TILE_WIDTH_SGIX				= 0x8140 # 1 I
//PIXEL_TILE_HEIGHT_SGIX				= 0x8141 # 1 I
//PIXEL_TILE_GRID_WIDTH_SGIX			= 0x8142 # 1 I
//
//PIXEL_TILE_GRID_HEIGHT_SGIX			= 0x8143 # 1 I
//PIXEL_TILE_GRID_DEPTH_SGIX			= 0x8144 # 1 I
//PIXEL_TILE_CACHE_SIZE_SGIX			= 0x8145 # 1 I
//
//###############################################################################
//
//SGIS_texture_filter4 enum:
//FILTER4_SGIS					= 0x8146
//TEXTURE_FILTER4_SIZE_SGIS			= 0x8147
//
//###############################################################################
//
//SGIX_sprite enum:
//SPRITE_SGIX					= 0x8148 # 1 I
//SPRITE_MODE_SGIX				= 0x8149 # 1 I
//SPRITE_AXIS_SGIX				= 0x814A # 3 F
//SPRITE_TRANSLATION_SGIX				= 0x814B # 3 F
//SPRITE_AXIAL_SGIX				= 0x814C
//SPRITE_OBJECT_ALIGNED_SGIX			= 0x814D
//SPRITE_EYE_ALIGNED_SGIX				= 0x814E
//
//###############################################################################
//
//# SGIS_texture4D (additional; see above): 0x814F
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//# IGNORE_BORDER was *not* promoted into OpenGL 1.2
//HP_convolution_border_modes enum:
//IGNORE_BORDER_HP				= 0x8150
//CONSTANT_BORDER					= 0x8151
//CONSTANT_BORDER_HP				= 0x8151
//#	 WRAP_BORDER					 = 0x8152   # Not actually promoted?
//REPLICATE_BORDER				= 0x8153
//REPLICATE_BORDER_HP				= 0x8153
//CONVOLUTION_BORDER_COLOR			= 0x8154
//CONVOLUTION_BORDER_COLOR_HP			= 0x8154
//
//###############################################################################
//
//# HP: 0x8155-0x816F
//
//###############################################################################
//
//SGIX_clipmap enum:
//LINEAR_CLIPMAP_LINEAR_SGIX			= 0x8170
//TEXTURE_CLIPMAP_CENTER_SGIX			= 0x8171
//TEXTURE_CLIPMAP_FRAME_SGIX			= 0x8172
//TEXTURE_CLIPMAP_OFFSET_SGIX			= 0x8173
//TEXTURE_CLIPMAP_VIRTUAL_DEPTH_SGIX		= 0x8174
//TEXTURE_CLIPMAP_LOD_OFFSET_SGIX			= 0x8175
//TEXTURE_CLIPMAP_DEPTH_SGIX			= 0x8176
//MAX_CLIPMAP_DEPTH_SGIX				= 0x8177 # 1 I
//MAX_CLIPMAP_VIRTUAL_DEPTH_SGIX			= 0x8178 # 1 I
//NEAREST_CLIPMAP_NEAREST_SGIX			= 0x844D
//NEAREST_CLIPMAP_LINEAR_SGIX			= 0x844E
//LINEAR_CLIPMAP_NEAREST_SGIX			= 0x844F
//
//###############################################################################
//
//SGIX_texture_scale_bias enum:
//POST_TEXTURE_FILTER_BIAS_SGIX			= 0x8179
//POST_TEXTURE_FILTER_SCALE_SGIX			= 0x817A
//POST_TEXTURE_FILTER_BIAS_RANGE_SGIX		= 0x817B # 2 F
//POST_TEXTURE_FILTER_SCALE_RANGE_SGIX		= 0x817C # 2 F
//
//###############################################################################
//
//SGIX_reference_plane enum:
//REFERENCE_PLANE_SGIX				= 0x817D # 1 I
//REFERENCE_PLANE_EQUATION_SGIX			= 0x817E # 4 F
//
//###############################################################################
//
//SGIX_ir_instrument1 enum:
//IR_INSTRUMENT1_SGIX				= 0x817F # 1 I
//
//###############################################################################
//
//SGIX_instruments enum:
//INSTRUMENT_BUFFER_POINTER_SGIX			= 0x8180
//INSTRUMENT_MEASUREMENTS_SGIX			= 0x8181 # 1 I
//
//###############################################################################
//
//SGIX_list_priority enum:
//LIST_PRIORITY_SGIX				= 0x8182
//
//###############################################################################
//
//SGIX_calligraphic_fragment enum:
//CALLIGRAPHIC_FRAGMENT_SGIX			= 0x8183 # 1 I
//
//###############################################################################
//
//SGIX_impact_pixel_texture enum:
//PIXEL_TEX_GEN_Q_CEILING_SGIX			= 0x8184
//PIXEL_TEX_GEN_Q_ROUND_SGIX			= 0x8185
//PIXEL_TEX_GEN_Q_FLOOR_SGIX			= 0x8186
//PIXEL_TEX_GEN_ALPHA_REPLACE_SGIX		= 0x8187
//PIXEL_TEX_GEN_ALPHA_NO_REPLACE_SGIX		= 0x8188
//PIXEL_TEX_GEN_ALPHA_LS_SGIX			= 0x8189
//PIXEL_TEX_GEN_ALPHA_MS_SGIX			= 0x818A
//
//###############################################################################
//
//SGIX_framezoom enum:
//FRAMEZOOM_SGIX					= 0x818B # 1 I
//FRAMEZOOM_FACTOR_SGIX				= 0x818C # 1 I
//MAX_FRAMEZOOM_FACTOR_SGIX			= 0x818D # 1 I
//
//###############################################################################
//
//SGIX_texture_lod_bias enum:
//TEXTURE_LOD_BIAS_S_SGIX				= 0x818E
//TEXTURE_LOD_BIAS_T_SGIX				= 0x818F
//TEXTURE_LOD_BIAS_R_SGIX				= 0x8190
//
//###############################################################################
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//SGIS_generate_mipmap enum:
//GENERATE_MIPMAP					= 0x8191
//GENERATE_MIPMAP_SGIS				= 0x8191
//GENERATE_MIPMAP_HINT				= 0x8192 # 1 I
//GENERATE_MIPMAP_HINT_SGIS			= 0x8192 # 1 I
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_spotlight_cutoff: 0x8193
//#	SPOT_CUTOFF_DELTA_SGIX				= 0x8193
//
//###############################################################################
//
//# SGIX_polynomial_ffd enum:
//GEOMETRY_DEFORMATION_SGIX			= 0x8194
//TEXTURE_DEFORMATION_SGIX			= 0x8195
//DEFORMATIONS_MASK_SGIX				= 0x8196 # 1 I
//MAX_DEFORMATION_ORDER_SGIX			= 0x8197
//
//###############################################################################
//
//SGIX_fog_offset enum:
//FOG_OFFSET_SGIX					= 0x8198 # 1 I
//FOG_OFFSET_VALUE_SGIX				= 0x8199 # 4 F
//
//###############################################################################
//
//SGIX_shadow enum:
//TEXTURE_COMPARE_SGIX				= 0x819A
//TEXTURE_COMPARE_OPERATOR_SGIX			= 0x819B
//TEXTURE_LEQUAL_R_SGIX				= 0x819C
//TEXTURE_GEQUAL_R_SGIX				= 0x819D
//
//###############################################################################
//
//# SGI private extension, not in enumext.spec
//# SGIX_igloo_interface: 0x819E-0x81A4
//#	IGLOO_FULLSCREEN_SGIX				= 0x819E
//#	IGLOO_VIEWPORT_OFFSET_SGIX			= 0x819F
//#	IGLOO_SWAPTMESH_SGIX				= 0x81A0
//#	IGLOO_COLORNORMAL_SGIX				= 0x81A1
//#	IGLOO_IRISGL_MODE_SGIX				= 0x81A2
//#	IGLOO_LMC_COLOR_SGIX				= 0x81A3
//#	IGLOO_TMESHMODE_SGIX				= 0x81A4
//
//###############################################################################
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# ARB_depth_texture enum:
//SGIX_depth_texture enum:
//DEPTH_COMPONENT16				= 0x81A5
//DEPTH_COMPONENT16_SGIX				= 0x81A5
//DEPTH_COMPONENT24				= 0x81A6
//DEPTH_COMPONENT24_SGIX				= 0x81A6
//DEPTH_COMPONENT32				= 0x81A7
//DEPTH_COMPONENT32_SGIX				= 0x81A7
//
//###############################################################################
//
//#EXT_compiled_vertex_array enum:
//#	 ARRAY_ELEMENT_LOCK_FIRST_EXT			 = 0x81A8
//#	 ARRAY_ELEMENT_LOCK_COUNT_EXT			 = 0x81A9
//
//###############################################################################
//
//#EXT_cull_vertex enum:
//#	 CULL_VERTEX_EXT				 = 0x81AA
//#	 CULL_VERTEX_EYE_POSITION_EXT			 = 0x81AB
//#	 CULL_VERTEX_OBJECT_POSITION_EXT		 = 0x81AC
//
//###############################################################################
//
//# Promoted from SGI?
//#EXT_index_array_formats enum:
//#	 IUI_V2F_EXT					 = 0x81AD
//#	 IUI_V3F_EXT					 = 0x81AE
//#	 IUI_N3F_V2F_EXT				 = 0x81AF
//#	 IUI_N3F_V3F_EXT				 = 0x81B0
//#	 T2F_IUI_V2F_EXT				 = 0x81B1
//#	 T2F_IUI_V3F_EXT				 = 0x81B2
//#	 T2F_IUI_N3F_V2F_EXT				 = 0x81B3
//#	 T2F_IUI_N3F_V3F_EXT				 = 0x81B4
//
//###############################################################################
//
//# Promoted from SGI?
//#EXT_index_func enum:
//#	 INDEX_TEST_EXT					 = 0x81B5
//#	 INDEX_TEST_FUNC_EXT				 = 0x81B6
//#	 INDEX_TEST_REF_EXT				 = 0x81B7
//
//###############################################################################
//
//# Promoted from SGI?
//#EXT_index_material enum:
//#	 INDEX_MATERIAL_EXT				 = 0x81B8
//#	 INDEX_MATERIAL_PARAMETER_EXT			 = 0x81B9
//#	 INDEX_MATERIAL_FACE_EXT			 = 0x81BA
//
//###############################################################################
//
//SGIX_ycrcb enum:
//YCRCB_422_SGIX					= 0x81BB
//YCRCB_444_SGIX					= 0x81BC
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGI_complex_type: 0x81BD-0x81C3
//#	COMPLEX_UNSIGNED_BYTE_SGI			= 0x81BD
//#	COMPLEX_BYTE_SGI				= 0x81BE
//#	COMPLEX_UNSIGNED_SHORT_SGI			= 0x81BF
//#	COMPLEX_SHORT_SGI				= 0x81C0
//#	COMPLEX_UNSIGNED_INT_SGI			= 0x81C1
//#	COMPLEX_INT_SGI					= 0x81C2
//#	COMPLEX_FLOAT_SGI				= 0x81C3
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGI_fft: 0x81C4-0x81CA
//#	POST_TRANSFORM_RED_SCALE_SGI			= ????	 # 1 F
//#	POST_TRANSFORM_GREEN_SCALE_SGI			= ????	 # 1 F
//#	POST_TRANSFORM_BLUE_SCALE_SGI			= ????	 # 1 F
//#	POST_TRANSFORM_ALPHA_SCALE_SGI			= ????	 # 1 F
//#	POST_TRANSFORM_RED_BIAS_SGI			= ????	 # 1 F
//#	POST_TRANSFORM_GREEN_BIAS_SGI			= ????	 # 1 F
//#	POST_TRANSFORM_BLUE_BIAS_SGI			= ????	 # 1 F
//#	POST_TRANSFORM_ALPHA_BIAS_SGI			= ????	 # 1 F
//#	PIXEL_TRANSFORM_OPERATOR_SGI			= 0x81C4 # 1 I
//#	CONVOLUTION_SGI					= 0x81C5
//#	FFT_1D_SGI					= 0x81C6
//#	PIXEL_TRANSFORM_SGI				= 0x81C7
//#	MAX_FFT_WIDTH_SGI				= 0x81C8
//#	SORT_SGI					= 0x81C9
//#	TRANSPOSE_SGI					= 0x81CA
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_nurbs_eval: 0x81CB-0x81CF
//#	MAP1_VERTEX_3_NURBS_SGIX			= 0x81CB # 1 I
//#	MAP1_VERTEX_4_NURBS_SGIX			= 0x81CC # 1 I
//#	MAP1_INDEX_NURBS_SGIX				= 0x81CD # 1 I
//#	MAP1_COLOR_4_NURBS_SGIX				= 0x81CE # 1 I
//#	MAP1_NORMAL_NURBS_SGIX				= 0x81CF # 1 I
//#	MAP1_TEXTURE_COORD_1_NURBS_SGIX			= 0x81E0 # 1 I
//#	MAP1_TEXTURE_COORD_2_NURBS_SGIX			= 0x81E1 # 1 I
//#	MAP1_TEXTURE_COORD_3_NURBS_SGIX			= 0x81E2 # 1 I
//#	MAP1_TEXTURE_COORD_4_NURBS_SGIX			= 0x81E3 # 1 I
//#	MAP2_VERTEX_3_NURBS_SGIX			= 0x81E4 # 1 I
//#	MAP2_VERTEX_4_NURBS_SGIX			= 0x81E5 # 1 I
//#	MAP2_INDEX_NURBS_SGIX				= 0x81E6 # 1 I
//#	MAP2_COLOR_4_NURBS_SGIX				= 0x81E7 # 1 I
//#	MAP2_NORMAL_NURBS_SGIX				= 0x81E8 # 1 I
//#	MAP2_TEXTURE_COORD_1_NURBS_SGIX			= 0x81E9 # 1 I
//#	MAP2_TEXTURE_COORD_2_NURBS_SGIX			= 0x81EA # 1 I
//#	MAP2_TEXTURE_COORD_3_NURBS_SGIX			= 0x81EB # 1 I
//#	MAP2_TEXTURE_COORD_4_NURBS_SGIX			= 0x81EC # 1 I
//#	NURBS_KNOT_COUNT_SGIX				= 0x81ED
//#	NURBS_KNOT_VECTOR_SGIX				= 0x81EE
//
//###############################################################################
//
//# Sun: 0x81D0-0x81DF
//
//# No extension spec, not in enumext.spec
//# SUNX_surface_hint enum:
//#	 SURFACE_SIZE_HINT_SUNX				= 0x81D2
//#	 LARGE_SUNX					= 0x81D3
//
//# SUNX_general_triangle_list enum:
//#	 RESTART_SUN					= 0x0001
//#	 REPLACE_MIDDLE_SUN				= 0x0002
//#	 REPLACE_OLDEST_SUN				= 0x0003
//#	 WRAP_BORDER_SUN				= 0x81D4
//#	 TRIANGLE_LIST_SUN				= 0x81D7
//#	 REPLACEMENT_CODE_SUN				= 0x81D8
//#	 REPLACEMENT_CODE_ARRAY_SUN			= 0x85C0
//#	 REPLACEMENT_CODE_ARRAY_TYPE_SUN		= 0x85C1
//#	 REPLACEMENT_CODE_ARRAY_STRIDE_SUN		= 0x85C2
//#	 REPLACEMENT_CODE_ARRAY_POINTER_SUN		= 0x85C3
//#	 R1UI_V3F_SUN					= 0x85C4
//#	 R1UI_C4UB_V3F_SUN				= 0x85C5
//#	 R1UI_C3F_V3F_SUN				= 0x85C6
//#	 R1UI_N3F_V3F_SUN				= 0x85C7
//#	 R1UI_C4F_N3F_V3F_SUN				= 0x85C8
//#	 R1UI_T2F_V3F_SUN				= 0x85C9
//#	 R1UI_T2F_N3F_V3F_SUN				= 0x85CA
//#	 R1UI_T2F_C4F_N3F_V3F_SUN			= 0x85CB
//
//# SUNX_constant_data enum:
//#	 UNPACK_CONSTANT_DATA_SUNX			= 0x81D5
//#	 TEXTURE_CONSTANT_DATA_SUNX			= 0x81D6
//
//# SUN_global_alpha enum:
//#	 GLOBAL_ALPHA_SUN				= 0x81D9
//#	 GLOBAL_ALPHA_FACTOR_SUN			= 0x81DA
//
//###############################################################################
//
//# SGIX_nurbs_eval (additional; see above): 0x81E0-0x81EE
//
//###############################################################################
//
//SGIS_texture_color_mask enum:
//TEXTURE_COLOR_WRITEMASK_SGIS			= 0x81EF
//
//###############################################################################
//
//SGIS_point_line_texgen enum:
//EYE_DISTANCE_TO_POINT_SGIS			= 0x81F0
//OBJECT_DISTANCE_TO_POINT_SGIS			= 0x81F1
//EYE_DISTANCE_TO_LINE_SGIS			= 0x81F2
//OBJECT_DISTANCE_TO_LINE_SGIS			= 0x81F3
//EYE_POINT_SGIS					= 0x81F4
//OBJECT_POINT_SGIS				= 0x81F5
//EYE_LINE_SGIS					= 0x81F6
//OBJECT_LINE_SGIS				= 0x81F7
//
//###############################################################################
//
//# VERSION_1_2 enum: (Promoted for OpenGL 1.2)
//EXT_separate_specular_color enum:
//LIGHT_MODEL_COLOR_CONTROL			= 0x81F8 # 1 I
//LIGHT_MODEL_COLOR_CONTROL_EXT			= 0x81F8
//SINGLE_COLOR					= 0x81F9
//SINGLE_COLOR_EXT				= 0x81F9
//SEPARATE_SPECULAR_COLOR				= 0x81FA
//SEPARATE_SPECULAR_COLOR_EXT			= 0x81FA
//
//###############################################################################
//
//EXT_shared_texture_palette enum:
//SHARED_TEXTURE_PALETTE_EXT			= 0x81FB # 1 I
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_fog_scale: 0x81FC-0x81FD
//#	FOG_SCALE_SGIX					= 0x81FC # 1 I
//#	FOG_SCALE_VALUE_SGIX				= 0x81FD # 1 F
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_fog_blend: 0x81FE-0x81FF
//#	FOG_BLEND_ALPHA_SGIX				= 0x81FE # 1 I
//#	FOG_BLEND_COLOR_SGIX				= 0x81FF # 1 I
//
//###############################################################################
//
//# ATI: 0x8200-0x820F (released by Microsoft 2002/9/16)
//# ATI_text_fragment_shader enum:
//#	TEXT_FRAGMENT_SHADER_ATI			= 0x8200
//
//###############################################################################
//
//# ARB: 0x8210-0x823F
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//#	FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING		= 0x8210    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE		= 0x8211    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_RED_SIZE			= 0x8212    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_GREEN_SIZE		= 0x8213    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_BLUE_SIZE		= 0x8214    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE		= 0x8215    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE		= 0x8216    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE		= 0x8217    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_DEFAULT				= 0x8218    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_UNDEFINED				= 0x8219    # 3.0 / ARB_fbo
//#	DEPTH_STENCIL_ATTACHMENT			= 0x821A    # 3.0 / ARB_fbo
//
//# VERSION_3_0 enum:
//#	MAJOR_VERSION					= 0x821B    # 3.0
//#	MINOR_VERSION					= 0x821C    # 3.0
//#	NUM_EXTENSIONS					= 0x821D    # 3.0
//#	CONTEXT_FLAGS					= 0x821E    # 3.0
//# 0x821F-0x8221 currently unused
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//#	INDEX						= 0x8222    # 3.0 / ARB_fbo
//
//# VERSION_3_0 enum:
//#	DEPTH_BUFFER					= 0x8223    # 3.0
//#	STENCIL_BUFFER					= 0x8224    # 3.0
//#	COMPRESSED_RED					= 0x8225    # 3.0
//#	COMPRESSED_RG					= 0x8226    # 3.0
//
//# VERSION_3_0 enum:
//# ARB_texture_rg enum: (note: no ARB suffixes)
//#	RG						= 0x8227    # 3.0 / ARB_trg
//#	RG_INTEGER					= 0x8228    # 3.0 / ARB_trg
//#	R8						= 0x8229    # 3.0 / ARB_trg
//#	R16						= 0x822A    # 3.0 / ARB_trg
//#	RG8						= 0x822B    # 3.0 / ARB_trg
//#	RG16						= 0x822C    # 3.0 / ARB_trg
//#	R16F						= 0x822D    # 3.0 / ARB_trg
//#	R32F						= 0x822E    # 3.0 / ARB_trg
//#	RG16F						= 0x822F    # 3.0 / ARB_trg
//#	RG32F						= 0x8230    # 3.0 / ARB_trg
//#	R8I						= 0x8231    # 3.0 / ARB_trg
//#	R8UI						= 0x8232    # 3.0 / ARB_trg
//#	R16I						= 0x8233    # 3.0 / ARB_trg
//#	R16UI						= 0x8234    # 3.0 / ARB_trg
//#	R32I						= 0x8235    # 3.0 / ARB_trg
//#	R32UI						= 0x8236    # 3.0 / ARB_trg
//#	RG8I						= 0x8237    # 3.0 / ARB_trg
//#	RG8UI						= 0x8238    # 3.0 / ARB_trg
//#	RG16I						= 0x8239    # 3.0 / ARB_trg
//#	RG16UI						= 0x823A    # 3.0 / ARB_trg
//#	RG32I						= 0x823B    # 3.0 / ARB_trg
//#	RG32UI						= 0x823C    # 3.0 / ARB_trg
//
//# ARB_future_use: 0x823D-0x823F
//
//###############################################################################
//
//# @@@ Any_vendor_future_use: 0x8240-0x82AF (released by Microsoft 2002/9/16)
//
//###############################################################################
//
//# ADD: 0x82B0-0x830F
//
//###############################################################################
//
//# SGIX_depth_pass_instrument enum: 0x8310-0x8312
//#	DEPTH_PASS_INSTRUMENT_SGIX			= 0x8310
//#	DEPTH_PASS_INSTRUMENT_COUNTERS_SGIX		= 0x8311
//#	DEPTH_PASS_INSTRUMENT_MAX_SGIX			= 0x8312
//
//###############################################################################
//
//# SGIX_fragments_instrument enum: 0x8313-0x8315
//#	FRAGMENTS_INSTRUMENT_SGIX			= 0x8313 # 1 I
//#	FRAGMENTS_INSTRUMENT_COUNTERS_SGIX		= 0x8314 # 1 I
//#	FRAGMENTS_INSTRUMENT_MAX_SGIX			= 0x8315 # 1 I
//
//###############################################################################
//
//SGIX_convolution_accuracy enum:
//CONVOLUTION_HINT_SGIX				= 0x8316 # 1 I
//
//###############################################################################
//
//# SGIX_color_matrix_accuracy: 0x8317
//
//###############################################################################
//
//# SGIX_ycrcba: 0x8318-0x8319
//#	YCRCB_SGIX					= 0x8318
//#	YCRCBA_SGIX					= 0x8319
//
//###############################################################################
//
//# SGIX_slim: 0x831A-0x831F
//#	UNPACK_COMPRESSED_SIZE_SGIX			= 0x831A
//#	PACK_MAX_COMPRESSED_SIZE_SGIX			= 0x831B
//#	PACK_COMPRESSED_SIZE_SGIX			= 0x831C
//#	SLIM8U_SGIX					= 0x831D
//#	SLIM10U_SGIX					= 0x831E
//#	SLIM12S_SGIX					= 0x831F
//
//###############################################################################
//
//SGIX_blend_alpha_minmax enum:
//ALPHA_MIN_SGIX					= 0x8320
//ALPHA_MAX_SGIX					= 0x8321
//
//###############################################################################
//
//# SGIX_scalebias_hint enum:
//#	SCALEBIAS_HINT_SGIX				= 0x8322
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_fog_layers: 0x8323-0x8328
//#	FOG_TYPE_SGIX					= 0x8323 # 1 I
//#	UNIFORM_SGIX					= 0x8324
//#	LAYERED_SGIX					= 0x8325
//#	FOG_GROUND_PLANE_SGIX				= 0x8326 # 4 F
//#	FOG_LAYERS_POINTS_SGIX				= 0x8327 # 1 I
//#	MAX_FOG_LAYERS_POINTS_SGIX			= 0x8328 # 1 I
//
//###############################################################################
//
//# SGIX_async enum:
//ASYNC_MARKER_SGIX				= 0x8329
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_texture_phase: 0x832A
//#	PHASE_SGIX					= 0x832A
//
//###############################################################################
//
//# SGIX_pixel_texture (additional; see above): 0x832B
//
//###############################################################################
//
//SGIX_async_histogram enum:
//ASYNC_HISTOGRAM_SGIX				= 0x832C
//MAX_ASYNC_HISTOGRAM_SGIX			= 0x832D
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_texture_mipmap_anisotropic: 0x832E-0x832F
//#	TEXTURE_MIPMAP_ANISOTROPY_SGIX			= 0x832E
//#	MAX_MIPMAP_ANISOTROPY_SGIX			= 0x832F # 1 I
//
//###############################################################################
//
//EXT_pixel_transform enum:
//PIXEL_TRANSFORM_2D_EXT				= 0x8330
//PIXEL_MAG_FILTER_EXT				= 0x8331
//PIXEL_MIN_FILTER_EXT				= 0x8332
//PIXEL_CUBIC_WEIGHT_EXT				= 0x8333
//CUBIC_EXT					= 0x8334
//AVERAGE_EXT					= 0x8335
//PIXEL_TRANSFORM_2D_STACK_DEPTH_EXT		= 0x8336
//MAX_PIXEL_TRANSFORM_2D_STACK_DEPTH_EXT		= 0x8337
//PIXEL_TRANSFORM_2D_MATRIX_EXT			= 0x8338
//
//# SUN_future_use: 0x8339-0x833F
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_cube_map: 0x8340-0x8348
//#	ENV_MAP_SGIX					= 0x8340
//#	CUBE_MAP_SGIX					= 0x8341
//#	CUBE_MAP_ZP_SGIX				= 0x8342
//#	CUBE_MAP_ZN_SGIX				= 0x8343
//#	CUBE_MAP_XN_SGIX				= 0x8344
//#	CUBE_MAP_XP_SGIX				= 0x8345
//#	CUBE_MAP_YN_SGIX				= 0x8346
//#	CUBE_MAP_YP_SGIX				= 0x8347
//#	CUBE_MAP_BINDING_SGIX				= 0x8348 # 1 I
//
//###############################################################################
//
//# Unfortunately, there was a collision promoting to EXT from SGIX.
//# Use fog_coord's value of 0x8452 instead of the previously
//#   assigned FRAGMENT_DEPTH_EXT = 0x834B.
//# EXT_light_texture: 0x8349-0x8352
//#	FRAGMENT_MATERIAL_EXT				= 0x8349
//#	FRAGMENT_NORMAL_EXT				= 0x834A
//#	FRAGMENT_COLOR_EXT				= 0x834C
//#	ATTENUATION_EXT					= 0x834D
//#	SHADOW_ATTENUATION_EXT				= 0x834E
//#	TEXTURE_APPLICATION_MODE_EXT			= 0x834F # 1 I
//#	TEXTURE_LIGHT_EXT				= 0x8350 # 1 I
//#	TEXTURE_MATERIAL_FACE_EXT			= 0x8351 # 1 I
//#	TEXTURE_MATERIAL_PARAMETER_EXT			= 0x8352 # 1 I
//#	use EXT_fog_coord FRAGMENT_DEPTH_EXT
//
//###############################################################################
//
//SGIS_pixel_texture enum:
//PIXEL_TEXTURE_SGIS				= 0x8353 # 1 I
//PIXEL_FRAGMENT_RGB_SOURCE_SGIS			= 0x8354 # 1 I
//PIXEL_FRAGMENT_ALPHA_SOURCE_SGIS		= 0x8355 # 1 I
//PIXEL_GROUP_COLOR_SGIS				= 0x8356 # 1 I
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_pixel_texture_bits: 0x8357-0x8359
//#	COLOR_TO_TEXTURE_COORD_SGIX			= 0x8357
//#	COLOR_BIT_PATTERN_SGIX				= 0x8358
//#	COLOR_VALUE_SGIX				= 0x8359
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_pixel_texture_lod: 0x835A
//#	PIXEL_TEX_GEN_LAMBDA_SOURCE_SGIX		= 0x835A
//
//###############################################################################
//
//# SGIX_line_quality_hint:
//#	LINE_QUALITY_HINT_SGIX				= 0x835B
//
//###############################################################################
//
//SGIX_async_pixel enum:
//ASYNC_TEX_IMAGE_SGIX				= 0x835C
//ASYNC_DRAW_PIXELS_SGIX				= 0x835D
//ASYNC_READ_PIXELS_SGIX				= 0x835E
//MAX_ASYNC_TEX_IMAGE_SGIX			= 0x835F
//MAX_ASYNC_DRAW_PIXELS_SGIX			= 0x8360
//MAX_ASYNC_READ_PIXELS_SGIX			= 0x8361
//
//###############################################################################
//
//# EXT_packed_pixels (additional; see above): 0x8362-0x8368
//
//###############################################################################
//
//SGIX_texture_coordinate_clamp enum:
//TEXTURE_MAX_CLAMP_S_SGIX			= 0x8369
//TEXTURE_MAX_CLAMP_T_SGIX			= 0x836A
//TEXTURE_MAX_CLAMP_R_SGIX			= 0x836B
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_fog_texture: 0x836C-0x836E
//#	FRAGMENT_FOG_SGIX				= 0x836C
//#	TEXTURE_FOG_SGIX				= 0x836D # 1 I
//#	FOG_PATCHY_FACTOR_SGIX				= 0x836E
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_fog_factor_to_alpha: 0x836F
//FOG_FACTOR_TO_ALPHA_SGIX			= 0x836F
//
//###############################################################################
//
//# HP: 0x8370-0x837F
//# NOTE: IBM is using values in this range, because of a bobble
//# when Pat Brown left at the same time as I assigned them the
//# next range and their registry became inconsistent. Unknown
//# whether HP has any conflicts as they have never reported using
//# any values in this range.
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# ARB_texture_mirrored_repeat enum:
//# IBM_texture_mirrored_repeat enum:
//#	MIRRORED_REPEAT					= 0x8370
//#	MIRRORED_REPEAT_ARB				= 0x8370
//#	MIRRORED_REPEAT_IBM				= 0x8370
//
//###############################################################################
//
//# IBM: 0x8380-0x839F
//
//###############################################################################
//
//# S3: 0x83A0-0x83BF
//
//# Extension #276
//# S3_s3tc enum: 0x83A0-0x83A3
//#	RGB_S3TC					= 0x83A0
//#	RGB4_S3TC					= 0x83A1
//#	RGBA_S3TC					= 0x83A2
//#	RGBA4_S3TC					= 0x83A3
//
//# S3_future_use: 0x83A4-0x83BF
//
//###############################################################################
//
//# Obsolete extension, never to be put in enumext.spec
//# SGIS_multitexture: 0x83C0-0x83E5
//#	SELECTED_TEXTURE_SGIS				= 0x83C0 # 1 I
//#	SELECTED_TEXTURE_COORD_SET_SGIS			= 0x83C1 # 1 I
//#	SELECTED_TEXTURE_TRANSFORM_SGIS			= 0x83C2 # 1 I
//#	MAX_TEXTURES_SGIS				= 0x83C3 # 1 I
//#	MAX_TEXTURE_COORD_SETS_SGIS			= 0x83C4 # 1 I
//#	TEXTURE_COORD_SET_INTERLEAVE_FACTOR_SGIS	= 0x83C5 # 1 I
//#	TEXTURE_ENV_COORD_SET_SGIS			= 0x83C6
//#	TEXTURE0_SGIS					= 0x83C7
//#	TEXTURE1_SGIS					= 0x83C8
//#	TEXTURE2_SGIS					= 0x83C9
//#	TEXTURE3_SGIS					= 0x83CA
//#
//# SGIS_multitexture_future_use: 0x83CB-0x83E5
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_bali_g_instruments: 0x83E6-0x83E9
//#	BALI_NUM_TRIS_CULLED_INSTRUMENT_SGIX		= 0x83E6 # 1 I
//#	BALI_NUM_PRIMS_CLIPPED_INSTRUMENT_SGIX		= 0x83E7 # 1 I
//#	BALI_NUM_PRIMS_REJECT_INSTRUMENT_SGIX		= 0x83E8 # 1 I
//#	BALI_NUM_PRIMS_CLIP_RESULT_INSTRUMENT_SGIX	= 0x83E9 # 1 I
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_bali_r_instruments: 0x83EA-0x83EC
//#	BALI_FRAGMENTS_GENERATED_INSTRUMENT_SGIX	= 0x83EA # 1 I
//#	BALI_DEPTH_PASS_INSTRUMENT_SGIX			= 0x83EB # 1 I
//#	BALI_R_CHIP_COUNT_SGIX				= 0x83EC # 1 I
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_occlusion_instrument: 0x83ED
//#	OCCLUSION_INSTRUMENT_SGIX			= 0x83ED # 1 I
//
//###############################################################################
//
//SGIX_vertex_preclip enum:
//VERTEX_PRECLIP_SGIX				= 0x83EE
//VERTEX_PRECLIP_HINT_SGIX			= 0x83EF
//
//###############################################################################
//
//# INTEL: 0x83F0-0x83FF
//# Note that this block was reclaimed from NTP, who never shipped it,
//#   and reassigned to Intel.
//
//EXT_texture_compression_s3tc enum:
//COMPRESSED_RGB_S3TC_DXT1_EXT			= 0x83F0
//COMPRESSED_RGBA_S3TC_DXT1_EXT			= 0x83F1
//COMPRESSED_RGBA_S3TC_DXT3_EXT			= 0x83F2
//COMPRESSED_RGBA_S3TC_DXT5_EXT			= 0x83F3
//
//INTEL_parallel_arrays enum:
//PARALLEL_ARRAYS_INTEL				= 0x83F4
//VERTEX_ARRAY_PARALLEL_POINTERS_INTEL		= 0x83F5
//NORMAL_ARRAY_PARALLEL_POINTERS_INTEL		= 0x83F6
//COLOR_ARRAY_PARALLEL_POINTERS_INTEL		= 0x83F7
//TEXTURE_COORD_ARRAY_PARALLEL_POINTERS_INTEL	= 0x83F8
//
//# INTEL_future_use: 0x83F9-0x83FF
//
//###############################################################################
//
//SGIX_fragment_lighting enum:
//FRAGMENT_LIGHTING_SGIX				= 0x8400 # 1 I
//FRAGMENT_COLOR_MATERIAL_SGIX			= 0x8401 # 1 I
//FRAGMENT_COLOR_MATERIAL_FACE_SGIX		= 0x8402 # 1 I
//FRAGMENT_COLOR_MATERIAL_PARAMETER_SGIX		= 0x8403 # 1 I
//MAX_FRAGMENT_LIGHTS_SGIX			= 0x8404 # 1 I
//MAX_ACTIVE_LIGHTS_SGIX				= 0x8405 # 1 I
//CURRENT_RASTER_NORMAL_SGIX			= 0x8406 # 1 I
//LIGHT_ENV_MODE_SGIX				= 0x8407 # 1 I
//FRAGMENT_LIGHT_MODEL_LOCAL_VIEWER_SGIX		= 0x8408 # 1 I
//FRAGMENT_LIGHT_MODEL_TWO_SIDE_SGIX		= 0x8409 # 1 I
//FRAGMENT_LIGHT_MODEL_AMBIENT_SGIX		= 0x840A # 4 F
//FRAGMENT_LIGHT_MODEL_NORMAL_INTERPOLATION_SGIX	= 0x840B # 1 I
//FRAGMENT_LIGHT0_SGIX				= 0x840C # 1 I
//FRAGMENT_LIGHT1_SGIX				= 0x840D
//FRAGMENT_LIGHT2_SGIX				= 0x840E
//FRAGMENT_LIGHT3_SGIX				= 0x840F
//FRAGMENT_LIGHT4_SGIX				= 0x8410
//FRAGMENT_LIGHT5_SGIX				= 0x8411
//FRAGMENT_LIGHT6_SGIX				= 0x8412
//FRAGMENT_LIGHT7_SGIX				= 0x8413
//
//# SGIX_fragment_lighting_future_use: 0x8414-0x842B
//
//###############################################################################
//
//SGIX_resample enum:
//PACK_RESAMPLE_SGIX				= 0x842C
//UNPACK_RESAMPLE_SGIX				= 0x842D
//RESAMPLE_REPLICATE_SGIX				= 0x842E
//RESAMPLE_ZERO_FILL_SGIX				= 0x842F
//RESAMPLE_DECIMATE_SGIX				= 0x8430
//
//# SGIX_resample_future_use: 0x8431-0x8435
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_fragment_lighting_space: 0x8436-0x8449
//#	EYE_SPACE_SGIX					= 0x8436
//#	TANGENT_SPACE_SGIX				= 0x8437
//#	OBJECT_SPACE_SGIX				= 0x8438
//#	TANGENT_ARRAY_SGIX				= 0x8439
//#	BINORMAL_ARRAY_SGIX				= 0x843A
//#	CURRENT_TANGENT_SGIX				= 0x843B # 3 F
//#	CURRENT_BINORMAL_SGIX				= 0x843C # 3 F
//#	FRAGMENT_LIGHT_SPACE_SGIX			= 0x843D # 1 I
//#	TANGENT_ARRAY_TYPE_SGIX				= 0x843E
//#	TANGENT_ARRAY_STRIDE_SGIX			= 0x843F
//#	TANGENT_ARRAY_COUNT_SGIX			= 0x8440
//#	BINORMAL_ARRAY_TYPE_SGIX			= 0x8441
//#	BINORMAL_ARRAY_STRIDE_SGIX			= 0x8442
//#	BINORMAL_ARRAY_COUNT_SGIX			= 0x8443
//#	TANGENT_ARRAY_POINTER_SGIX			= 0x8444
//#	BINORMAL_ARRAY_POINTER_SGIX			= 0x8445
//#	MAP1_TANGENT_SGIX				= 0x8446
//#	MAP2_TANGENT_SGIX				= 0x8447
//#	MAP1_BINORMAL_SGIX				= 0x8448
//#	MAP2_BINORMAL_SGIX				= 0x8449
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_bali_timer_instruments: 0x844A-0x844C
//#	BALI_GEOM_TIMER_INSTRUMENT_SGIX			= 0x844A # 1 I
//#	BALI_RASTER_TIMER_INSTRUMENT_SGIX		= 0x844B # 1 I
//#	BALI_INSTRUMENT_TIME_UNIT_SGIX			= 0x844C # 1 I
//
//###############################################################################
//
//# SGIX_clipmap (additional; see above): 0x844D-0x844F
//
//###############################################################################
//
//# SGI (actually brokered for Id Software): 0x8450-0x845F
//
//# VERSION_1_5 enum: (Consistent naming scheme for OpenGL 1.5)
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# EXT_fog_coord enum:
//#	FOG_COORD_SRC					= GL_FOG_COORDINATE_SOURCE
//#	FOG_COORDINATE_SOURCE				= 0x8450 # 1 I
//#	FOG_COORDINATE_SOURCE_EXT			= 0x8450 # 1 I
//#	FOG_COORD					= GL_FOG_COORDINATE
//#	FOG_COORDINATE					= 0x8451
//#	FOG_COORDINATE_EXT				= 0x8451
//#	FRAGMENT_DEPTH					= 0x8452
//#	FRAGMENT_DEPTH_EXT				= 0x8452
//#	CURRENT_FOG_COORD				= GL_CURRENT_FOG_COORDINATE
//#	CURRENT_FOG_COORDINATE				= 0x8453 # 1 F
//#	CURRENT_FOG_COORDINATE_EXT			= 0x8453 # 1 F
//#	FOG_COORD_ARRAY_TYPE				= GL_FOG_COORDINATE_ARRAY_TYPE
//#	FOG_COORDINATE_ARRAY_TYPE			= 0x8454 # 1 I
//#	FOG_COORDINATE_ARRAY_TYPE_EXT			= 0x8454 # 1 I
//#	FOG_COORD_ARRAY_STRIDE				= GL_FOG_COORDINATE_ARRAY_STRIDE
//#	FOG_COORDINATE_ARRAY_STRIDE			= 0x8455 # 1 I
//#	FOG_COORDINATE_ARRAY_STRIDE_EXT			= 0x8455 # 1 I
//#	FOG_COORD_ARRAY_POINTER				= GL_FOG_COORDINATE_ARRAY_POINTER
//#	FOG_COORDINATE_ARRAY_POINTER			= 0x8456
//#	FOG_COORDINATE_ARRAY_POINTER_EXT		= 0x8456
//#	FOG_COORD_ARRAY					= GL_FOG_COORDINATE_ARRAY
//#	FOG_COORDINATE_ARRAY				= 0x8457 # 1 I
//#	FOG_COORDINATE_ARRAY_EXT			= 0x8457 # 1 I
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# EXT_secondary_color enum:
//# ARB_vertex_program enum:
//#	COLOR_SUM					= 0x8458 # 1 I
//#	COLOR_SUM_EXT					= 0x8458 # 1 I
//#	COLOR_SUM_ARB					= 0x8458 # 1 I	# ARB_vertex_program
//#	CURRENT_SECONDARY_COLOR				= 0x8459 # 3 F
//#	CURRENT_SECONDARY_COLOR_EXT			= 0x8459 # 3 F
//#	SECONDARY_COLOR_ARRAY_SIZE			= 0x845A # 1 I
//#	SECONDARY_COLOR_ARRAY_SIZE_EXT			= 0x845A # 1 I
//#	SECONDARY_COLOR_ARRAY_TYPE			= 0x845B # 1 I
//#	SECONDARY_COLOR_ARRAY_TYPE_EXT			= 0x845B # 1 I
//#	SECONDARY_COLOR_ARRAY_STRIDE			= 0x845C # 1 I
//#	SECONDARY_COLOR_ARRAY_STRIDE_EXT		= 0x845C # 1 I
//#	SECONDARY_COLOR_ARRAY_POINTER			= 0x845D
//#	SECONDARY_COLOR_ARRAY_POINTER_EXT		= 0x845D
//#	SECONDARY_COLOR_ARRAY				= 0x845E # 1 I
//#	SECONDARY_COLOR_ARRAY_EXT			= 0x845E # 1 I
//
//# VERSION_2_1 enum:
//#	CURRENT_RASTER_SECONDARY_COLOR			= 0x845F
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_icc_texture enum:
//#	RGB_ICC_SGIX					= 0x8460
//#	RGBA_ICC_SGIX					= 0x8461
//#	ALPHA_ICC_SGIX					= 0x8462
//#	LUMINANCE_ICC_SGIX				= 0x8463
//#	INTENSITY_ICC_SGIX				= 0x8464
//#	LUMINANCE_ALPHA_ICC_SGIX			= 0x8465
//#	R5_G6_B5_ICC_SGIX				= 0x8466
//#	R5_G6_B5_A8_ICC_SGIX				= 0x8467
//#	ALPHA16_ICC_SGIX				= 0x8468
//#	LUMINANCE16_ICC_SGIX				= 0x8469
//#	INTENSITY16_ICC_SGIX				= 0x846A
//#	LUMINANCE16_ALPHA8_ICC_SGIX			= 0x846B
//
//###############################################################################
//
//# SGI_future_use: 0x846C
//
//###############################################################################
//
//# SMOOTH_* enums are new names for pre-1.2 enums.
//VERSION_1_2 enum:
//SMOOTH_POINT_SIZE_RANGE				= 0x0B12 # 2 F
//SMOOTH_POINT_SIZE_GRANULARITY			= 0x0B13 # 1 F
//SMOOTH_LINE_WIDTH_RANGE				= 0x0B22 # 2 F
//SMOOTH_LINE_WIDTH_GRANULARITY			= 0x0B23 # 1 F
//ALIASED_POINT_SIZE_RANGE			= 0x846D # 2 F
//ALIASED_LINE_WIDTH_RANGE			= 0x846E # 2 F
//
//###############################################################################
//
//# SGI_future_use: 0x846F
//
//###############################################################################
//
//# ATI Technologies (vendor multitexture, spec not yet released): 0x8470-0x848F
//
//###############################################################################
//
//# REND (Rendition): 0x8490-0x849F
//
//# REND_screen_coordinates enum:
//#	SCREEN_COORDINATES_REND				= 0x8490
//#	INVERTED_SCREEN_W_REND				= 0x8491
//
//###############################################################################
//
//# ATI Technologies (vendor multitexture, spec not yet released): 0x84A0-84BF
//
//###############################################################################
//
//# ARB: 0x84C0-0x84EF
//
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//# ARB_multitexture enum:
//#	TEXTURE0					= 0x84C0
//#	TEXTURE0_ARB					= 0x84C0
//#	TEXTURE1					= 0x84C1
//#	TEXTURE1_ARB					= 0x84C1
//#	TEXTURE2					= 0x84C2
//#	TEXTURE2_ARB					= 0x84C2
//#	TEXTURE3					= 0x84C3
//#	TEXTURE3_ARB					= 0x84C3
//#	TEXTURE4					= 0x84C4
//#	TEXTURE4_ARB					= 0x84C4
//#	TEXTURE5					= 0x84C5
//#	TEXTURE5_ARB					= 0x84C5
//#	TEXTURE6					= 0x84C6
//#	TEXTURE6_ARB					= 0x84C6
//#	TEXTURE7					= 0x84C7
//#	TEXTURE7_ARB					= 0x84C7
//#	TEXTURE8					= 0x84C8
//#	TEXTURE8_ARB					= 0x84C8
//#	TEXTURE9					= 0x84C9
//#	TEXTURE9_ARB					= 0x84C9
//#	TEXTURE10					= 0x84CA
//#	TEXTURE10_ARB					= 0x84CA
//#	TEXTURE11					= 0x84CB
//#	TEXTURE11_ARB					= 0x84CB
//#	TEXTURE12					= 0x84CC
//#	TEXTURE12_ARB					= 0x84CC
//#	TEXTURE13					= 0x84CD
//#	TEXTURE13_ARB					= 0x84CD
//#	TEXTURE14					= 0x84CE
//#	TEXTURE14_ARB					= 0x84CE
//#	TEXTURE15					= 0x84CF
//#	TEXTURE15_ARB					= 0x84CF
//#	TEXTURE16					= 0x84D0
//#	TEXTURE16_ARB					= 0x84D0
//#	TEXTURE17					= 0x84D1
//#	TEXTURE17_ARB					= 0x84D1
//#	TEXTURE18					= 0x84D2
//#	TEXTURE18_ARB					= 0x84D2
//#	TEXTURE19					= 0x84D3
//#	TEXTURE19_ARB					= 0x84D3
//#	TEXTURE20					= 0x84D4
//#	TEXTURE20_ARB					= 0x84D4
//#	TEXTURE21					= 0x84D5
//#	TEXTURE21_ARB					= 0x84D5
//#	TEXTURE22					= 0x84D6
//#	TEXTURE22_ARB					= 0x84D6
//#	TEXTURE23					= 0x84D7
//#	TEXTURE23_ARB					= 0x84D7
//#	TEXTURE24					= 0x84D8
//#	TEXTURE24_ARB					= 0x84D8
//#	TEXTURE25					= 0x84D9
//#	TEXTURE25_ARB					= 0x84D9
//#	TEXTURE26					= 0x84DA
//#	TEXTURE26_ARB					= 0x84DA
//#	TEXTURE27					= 0x84DB
//#	TEXTURE27_ARB					= 0x84DB
//#	TEXTURE28					= 0x84DC
//#	TEXTURE28_ARB					= 0x84DC
//#	TEXTURE29					= 0x84DD
//#	TEXTURE29_ARB					= 0x84DD
//#	TEXTURE30					= 0x84DE
//#	TEXTURE30_ARB					= 0x84DE
//#	TEXTURE31					= 0x84DF
//#	TEXTURE31_ARB					= 0x84DF
//#	ACTIVE_TEXTURE					= 0x84E0 # 1 I
//#	ACTIVE_TEXTURE_ARB				= 0x84E0 # 1 I
//#	CLIENT_ACTIVE_TEXTURE				= 0x84E1 # 1 I
//#	CLIENT_ACTIVE_TEXTURE_ARB			= 0x84E1 # 1 I
//#	MAX_TEXTURE_UNITS				= 0x84E2 # 1 I
//#	MAX_TEXTURE_UNITS_ARB				= 0x84E2 # 1 I
//
//
//
//
//###############################################################################
//
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//# ARB_transpose_matrix enum:
//#	TRANSPOSE_MODELVIEW_MATRIX			= 0x84E3 # 16 F
//#	TRANSPOSE_MODELVIEW_MATRIX_ARB			= 0x84E3 # 16 F
//#	TRANSPOSE_PROJECTION_MATRIX			= 0x84E4 # 16 F
//#	TRANSPOSE_PROJECTION_MATRIX_ARB			= 0x84E4 # 16 F
//#	TRANSPOSE_TEXTURE_MATRIX			= 0x84E5 # 16 F
//#	TRANSPOSE_TEXTURE_MATRIX_ARB			= 0x84E5 # 16 F
//#	TRANSPOSE_COLOR_MATRIX				= 0x84E6 # 16 F
//#	TRANSPOSE_COLOR_MATRIX_ARB			= 0x84E6 # 16 F
//
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//# ARB_texture_env_combine enum:
//#	SUBTRACT					= 0x84E7
//#	SUBTRACT_ARB					= 0x84E7
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_framebuffer_object (additional; see below):
//#	MAX_RENDERBUFFER_SIZE				= 0x84E8	# 3.0 / ARB_fbo
//#	MAX_RENDERBUFFER_SIZE_EXT			= 0x84E8
//
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//# ARB_texture_compression enum:
//#	COMPRESSED_ALPHA				= 0x84E9
//#	COMPRESSED_ALPHA_ARB				= 0x84E9
//#	COMPRESSED_LUMINANCE				= 0x84EA
//#	COMPRESSED_LUMINANCE_ARB			= 0x84EA
//#	COMPRESSED_LUMINANCE_ALPHA			= 0x84EB
//#	COMPRESSED_LUMINANCE_ALPHA_ARB			= 0x84EB
//#	COMPRESSED_INTENSITY				= 0x84EC
//#	COMPRESSED_INTENSITY_ARB			= 0x84EC
//#	COMPRESSED_RGB					= 0x84ED
//#	COMPRESSED_RGB_ARB				= 0x84ED
//#	COMPRESSED_RGBA					= 0x84EE
//#	COMPRESSED_RGBA_ARB				= 0x84EE
//#	TEXTURE_COMPRESSION_HINT			= 0x84EF
//#	TEXTURE_COMPRESSION_HINT_ARB			= 0x84EF
//#	TEXTURE_COMPRESSED_IMAGE_SIZE			= 0x86A0
//#	TEXTURE_COMPRESSED_IMAGE_SIZE_ARB		= 0x86A0
//#	TEXTURE_COMPRESSED				= 0x86A1
//#	TEXTURE_COMPRESSED_ARB				= 0x86A1
//#	NUM_COMPRESSED_TEXTURE_FORMATS			= 0x86A2
//#	NUM_COMPRESSED_TEXTURE_FORMATS_ARB		= 0x86A2
//#	COMPRESSED_TEXTURE_FORMATS			= 0x86A3
//#	COMPRESSED_TEXTURE_FORMATS_ARB			= 0x86A3
//
//###############################################################################
//
//# NVIDIA: 0x84F0-0x855F
//
//# NV_future_use: 0x84F0-0x84F1
//
//# NV_fence enum:
//#	ALL_COMPLETED_NV				= 0x84F2
//#	FENCE_STATUS_NV					= 0x84F3
//#	FENCE_CONDITION_NV				= 0x84F4
//
//# ARB_texture_rectangle enum:
//# NV_texture_rectangle enum:
//#	TEXTURE_RECTANGLE_ARB				= 0x84F5
//#	TEXTURE_RECTANGLE_NV				= 0x84F5
//#	TEXTURE_BINDING_RECTANGLE_ARB			= 0x84F6
//#	TEXTURE_BINDING_RECTANGLE_NV			= 0x84F6
//#	PROXY_TEXTURE_RECTANGLE_ARB			= 0x84F7
//#	PROXY_TEXTURE_RECTANGLE_NV			= 0x84F7
//#	MAX_RECTANGLE_TEXTURE_SIZE_ARB			= 0x84F8
//#	MAX_RECTANGLE_TEXTURE_SIZE_NV			= 0x84F8
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_packed_depth_stencil enum:
//# NV_packed_depth_stencil enum:
//#	DEPTH_STENCIL					= 0x84F9    # 3.0 / ARB_fbo
//#	DEPTH_STENCIL_EXT				= 0x84F9
//#	DEPTH_STENCIL_NV				= 0x84F9
//#	UNSIGNED_INT_24_8				= 0x84FA    # 3.0 / ARB_fbo
//#	UNSIGNED_INT_24_8_EXT				= 0x84FA
//#	UNSIGNED_INT_24_8_NV				= 0x84FA
//
//# NV_future_use: 0x84FB-0x84FC
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# EXT_texture_lod_bias enum:
//#	MAX_TEXTURE_LOD_BIAS				= 0x84FD
//#	MAX_TEXTURE_LOD_BIAS_EXT			= 0x84FD
//
//# EXT_texture_filter_anisotropic enum:
//#	TEXTURE_MAX_ANISOTROPY_EXT			= 0x84FE
//#	MAX_TEXTURE_MAX_ANISOTROPY_EXT			= 0x84FF
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# EXT_texture_lod_bias enum:
//#	TEXTURE_FILTER_CONTROL				= 0x8500
//#	TEXTURE_FILTER_CONTROL_EXT			= 0x8500
//#	TEXTURE_LOD_BIAS				= 0x8501
//#	TEXTURE_LOD_BIAS_EXT				= 0x8501
//
//# EXT_vertex_weighting enum:
//#	MODELVIEW1_STACK_DEPTH_EXT			= 0x8502
//
//# NV_texture_env_combine4 (additional; see below): 0x8503
//
//# NV_light_max_exponent enum:
//#	MAX_SHININESS_NV				= 0x8504
//#	MAX_SPOT_EXPONENT_NV				= 0x8505
//
//# EXT_vertex_weighting enum:
//#	MODELVIEW_MATRIX1_EXT				= 0x8506
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# EXT_stencil_wrap enum:
//#	INCR_WRAP					= 0x8507
//#	INCR_WRAP_EXT					= 0x8507
//#	DECR_WRAP					= 0x8508
//#	DECR_WRAP_EXT					= 0x8508
//
//# EXT_vertex_weighting enum:
//#	VERTEX_WEIGHTING_EXT				= 0x8509
//#	MODELVIEW1_EXT					= 0x850A
//#	CURRENT_VERTEX_WEIGHT_EXT			= 0x850B
//#	VERTEX_WEIGHT_ARRAY_EXT				= 0x850C
//#	VERTEX_WEIGHT_ARRAY_SIZE_EXT			= 0x850D
//#	VERTEX_WEIGHT_ARRAY_TYPE_EXT			= 0x850E
//#	VERTEX_WEIGHT_ARRAY_STRIDE_EXT			= 0x850F
//#	VERTEX_WEIGHT_ARRAY_POINTER_EXT			= 0x8510
//
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//# Note: these are also exposed as NV and EXT, as well as ARB
//# NV_texgen_reflection enum:
//# EXT_texture_cube_map enum:
//# ARB_texture_cube_map enum:
//#	NORMAL_MAP					= 0x8511
//#	NORMAL_MAP_ARB					= 0x8511
//#	REFLECTION_MAP					= 0x8512
//#	REFLECTION_MAP_ARB				= 0x8512
//#	TEXTURE_CUBE_MAP				= 0x8513
//#	TEXTURE_CUBE_MAP_ARB				= 0x8513
//#	TEXTURE_BINDING_CUBE_MAP			= 0x8514
//#	TEXTURE_BINDING_CUBE_MAP_ARB			= 0x8514
//#	TEXTURE_CUBE_MAP_POSITIVE_X			= 0x8515
//#	TEXTURE_CUBE_MAP_POSITIVE_X_ARB			= 0x8515
//#	TEXTURE_CUBE_MAP_NEGATIVE_X			= 0x8516
//#	TEXTURE_CUBE_MAP_NEGATIVE_X_ARB			= 0x8516
//#	TEXTURE_CUBE_MAP_POSITIVE_Y			= 0x8517
//#	TEXTURE_CUBE_MAP_POSITIVE_Y_ARB			= 0x8517
//#	TEXTURE_CUBE_MAP_NEGATIVE_Y			= 0x8518
//#	TEXTURE_CUBE_MAP_NEGATIVE_Y_ARB			= 0x8518
//#	TEXTURE_CUBE_MAP_POSITIVE_Z			= 0x8519
//#	TEXTURE_CUBE_MAP_POSITIVE_Z_ARB			= 0x8519
//#	TEXTURE_CUBE_MAP_NEGATIVE_Z			= 0x851A
//#	TEXTURE_CUBE_MAP_NEGATIVE_Z_ARB			= 0x851A
//#	PROXY_TEXTURE_CUBE_MAP				= 0x851B
//#	PROXY_TEXTURE_CUBE_MAP_ARB			= 0x851B
//#	MAX_CUBE_MAP_TEXTURE_SIZE			= 0x851C
//#	MAX_CUBE_MAP_TEXTURE_SIZE_ARB			= 0x851C
//
//# NV_vertex_array_range enum:
//#	VERTEX_ARRAY_RANGE_NV				= 0x851D
//#	VERTEX_ARRAY_RANGE_LENGTH_NV			= 0x851E
//#	VERTEX_ARRAY_RANGE_VALID_NV			= 0x851F
//#	MAX_VERTEX_ARRAY_RANGE_ELEMENT_NV		= 0x8520
//#	VERTEX_ARRAY_RANGE_POINTER_NV			= 0x8521
//
//# @@@ How does this interact with NV_vertex_array_range?
//# APPLE_vertex_array_range enum:
//#	VERTEX_ARRAY_RANGE_APPLE			= 0x851D
//#	VERTEX_ARRAY_RANGE_LENGTH_APPLE			= 0x851E
//#	VERTEX_ARRAY_STORAGE_HINT_APPLE			= 0x851F
//#	VERTEX_ARRAY_RANGE_POINTER_APPLE		= 0x8521
//#	STORAGE_CACHED_APPLE				= 0x85BE
//#	STORAGE_SHARED_APPLE				= 0x85BF
//
//# NV_register_combiners enum:
//#	REGISTER_COMBINERS_NV				= 0x8522
//#	VARIABLE_A_NV					= 0x8523
//#	VARIABLE_B_NV					= 0x8524
//#	VARIABLE_C_NV					= 0x8525
//#	VARIABLE_D_NV					= 0x8526
//#	VARIABLE_E_NV					= 0x8527
//#	VARIABLE_F_NV					= 0x8528
//#	VARIABLE_G_NV					= 0x8529
//#	CONSTANT_COLOR0_NV				= 0x852A
//#	CONSTANT_COLOR1_NV				= 0x852B
//#	PRIMARY_COLOR_NV				= 0x852C
//#	SECONDARY_COLOR_NV				= 0x852D
//#	SPARE0_NV					= 0x852E
//#	SPARE1_NV					= 0x852F
//#	DISCARD_NV					= 0x8530
//#	E_TIMES_F_NV					= 0x8531
//#	SPARE0_PLUS_SECONDARY_COLOR_NV			= 0x8532
//#	UNSIGNED_IDENTITY_NV				= 0x8536
//#	UNSIGNED_INVERT_NV				= 0x8537
//#	EXPAND_NORMAL_NV				= 0x8538
//#	EXPAND_NEGATE_NV				= 0x8539
//#	HALF_BIAS_NORMAL_NV				= 0x853A
//#	HALF_BIAS_NEGATE_NV				= 0x853B
//#	SIGNED_IDENTITY_NV				= 0x853C
//#	UNSIGNED_NEGATE_NV				= 0x853D
//#	SCALE_BY_TWO_NV					= 0x853E
//#	SCALE_BY_FOUR_NV				= 0x853F
//#	SCALE_BY_ONE_HALF_NV				= 0x8540
//#	BIAS_BY_NEGATIVE_ONE_HALF_NV			= 0x8541
//#	COMBINER_INPUT_NV				= 0x8542
//#	COMBINER_MAPPING_NV				= 0x8543
//#	COMBINER_COMPONENT_USAGE_NV			= 0x8544
//#	COMBINER_AB_DOT_PRODUCT_NV			= 0x8545
//#	COMBINER_CD_DOT_PRODUCT_NV			= 0x8546
//#	COMBINER_MUX_SUM_NV				= 0x8547
//#	COMBINER_SCALE_NV				= 0x8548
//#	COMBINER_BIAS_NV				= 0x8549
//#	COMBINER_AB_OUTPUT_NV				= 0x854A
//#	COMBINER_CD_OUTPUT_NV				= 0x854B
//#	COMBINER_SUM_OUTPUT_NV				= 0x854C
//#	MAX_GENERAL_COMBINERS_NV			= 0x854D
//#	NUM_GENERAL_COMBINERS_NV			= 0x854E
//#	COLOR_SUM_CLAMP_NV				= 0x854F
//#	COMBINER0_NV					= 0x8550
//#	COMBINER1_NV					= 0x8551
//#	COMBINER2_NV					= 0x8552
//#	COMBINER3_NV					= 0x8553
//#	COMBINER4_NV					= 0x8554
//#	COMBINER5_NV					= 0x8555
//#	COMBINER6_NV					= 0x8556
//#	COMBINER7_NV					= 0x8557
//
//# NV_vertex_array_range2:
//#	VERTEX_ARRAY_RANGE_WITHOUT_FLUSH_NV		= 0x8533
//
//# NV_multisample_filter_hint:
//#	MULTISAMPLE_FILTER_HINT_NV			= 0x8534
//
//# NV_register_combiners2 enum:
//#	PER_STAGE_CONSTANTS_NV				= 0x8535
//
//# NV_register_combiners (additional; see above): 0x8536-0x8557
//
//# NV_primitive_restart enum:
//#	PRIMITIVE_RESTART_NV				= 0x8558
//#	PRIMITIVE_RESTART_INDEX_NV			= 0x8559
//
//# NV_fog_distance enum:
//#	FOG_GEN_MODE_NV					= 0x855A
//#	EYE_RADIAL_NV					= 0x855B
//#	EYE_PLANE_ABSOLUTE_NV				= 0x855C
//
//# NV_texgen_emboss enum:
//#	EMBOSS_LIGHT_NV					= 0x855D
//#	EMBOSS_CONSTANT_NV				= 0x855E
//#	EMBOSS_MAP_NV					= 0x855F
//
//###############################################################################
//
//# Intergraph/Intense3D/3Dlabs: 0x8560-0x856F
//
//# INGR_color_clamp enum:
//#	RED_MIN_CLAMP_INGR				= 0x8560
//#	GREEN_MIN_CLAMP_INGR				= 0x8561
//#	BLUE_MIN_CLAMP_INGR				= 0x8562
//#	ALPHA_MIN_CLAMP_INGR				= 0x8563
//#	RED_MAX_CLAMP_INGR				= 0x8564
//#	GREEN_MAX_CLAMP_INGR				= 0x8565
//#	BLUE_MAX_CLAMP_INGR				= 0x8566
//#	ALPHA_MAX_CLAMP_INGR				= 0x8567
//
//# INGR_interlace_read enum:
//#	INTERLACE_READ_INGR				= 0x8568
//
//# 3Dlabs_future_use: 0x8569-0x856F
//
//###############################################################################
//
//# ATI/NVIDIA: 0x8570-0x859F
//
//# VERSION_1_5 enum: (Consistent naming scheme for OpenGL 1.5)
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//# EXT_texture_env_combine enum:
//#	COMBINE						= 0x8570
//#	COMBINE_EXT					= 0x8570
//#	COMBINE_RGB					= 0x8571
//#	COMBINE_RGB_EXT					= 0x8571
//#	COMBINE_ALPHA					= 0x8572
//#	COMBINE_ALPHA_EXT				= 0x8572
//#	RGB_SCALE					= 0x8573
//#	RGB_SCALE_EXT					= 0x8573
//#	ADD_SIGNED					= 0x8574
//#	ADD_SIGNED_EXT					= 0x8574
//#	INTERPOLATE					= 0x8575
//#	INTERPOLATE_EXT					= 0x8575
//#	CONSTANT					= 0x8576
//#	CONSTANT_EXT					= 0x8576
//#	PRIMARY_COLOR					= 0x8577
//#	PRIMARY_COLOR_EXT				= 0x8577
//#	PREVIOUS					= 0x8578
//#	PREVIOUS_EXT					= 0x8578
//#	SRC0_RGB					= GL_SOURCE0_RGB
//#	SOURCE0_RGB					= 0x8580
//#	SOURCE0_RGB_EXT					= 0x8580
//#	SRC1_RGB					= GL_SOURCE1_RGB
//#	SOURCE1_RGB					= 0x8581
//#	SOURCE1_RGB_EXT					= 0x8581
//#	SRC2_RGB					= GL_SOURCE2_RGB
//#	SOURCE2_RGB					= 0x8582
//#	SOURCE2_RGB_EXT					= 0x8582
//#	SRC0_ALPHA					= GL_SOURCE0_ALPHA
//#	SOURCE0_ALPHA					= 0x8588
//#	SOURCE0_ALPHA_EXT				= 0x8588
//#	SRC1_ALPHA					= GL_SOURCE1_ALPHA
//#	SOURCE1_ALPHA					= 0x8589
//#	SOURCE1_ALPHA_EXT				= 0x8589
//#	SRC2_ALPHA					= GL_SOURCE2_ALPHA
//#	SOURCE2_ALPHA					= 0x858A
//#	SOURCE2_ALPHA_EXT				= 0x858A
//#	OPERAND0_RGB					= 0x8590
//#	OPERAND0_RGB_EXT				= 0x8590
//#	OPERAND1_RGB					= 0x8591
//#	OPERAND1_RGB_EXT				= 0x8591
//#	OPERAND2_RGB					= 0x8592
//#	OPERAND2_RGB_EXT				= 0x8592
//#	OPERAND0_ALPHA					= 0x8598
//#	OPERAND0_ALPHA_EXT				= 0x8598
//#	OPERAND1_ALPHA					= 0x8599
//#	OPERAND1_ALPHA_EXT				= 0x8599
//#	OPERAND2_ALPHA					= 0x859A
//#	OPERAND2_ALPHA_EXT				= 0x859A
//
//# NV_texture_env_combine4 enum:
//#	COMBINE4_NV					= 0x8503
//#	SOURCE3_RGB_NV					= 0x8583
//#	SOURCE3_ALPHA_NV				= 0x858B
//#	OPERAND3_RGB_NV					= 0x8593
//#	OPERAND3_ALPHA_NV				= 0x859B
//
//# "Future use" => "additional combiner input/output enums" only
//# ATI/NVIDIA_future_use: 0x8584-0x8587
//# ATI/NVIDIA_future_use: 0x858C-0x858F
//# ATI/NVIDIA_future_use: 0x8594-0x8597
//# ATI/NVIDIA_future_use: 0x859C-0x859F
//
//###############################################################################
//
//SGIX_subsample enum:
//PACK_SUBSAMPLE_RATE_SGIX			= 0x85A0
//UNPACK_SUBSAMPLE_RATE_SGIX			= 0x85A1
//PIXEL_SUBSAMPLE_4444_SGIX			= 0x85A2
//PIXEL_SUBSAMPLE_2424_SGIX			= 0x85A3
//PIXEL_SUBSAMPLE_4242_SGIX			= 0x85A4
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIS_color_range: 0x85A5-0x85AD
//#	EXTENDED_RANGE_SGIS				= 0x85A5
//#	MIN_RED_SGIS					= 0x85A6
//#	MAX_RED_SGIS					= 0x85A7
//#	MIN_GREEN_SGIS					= 0x85A8
//#	MAX_GREEN_SGIS					= 0x85A9
//#	MIN_BLUE_SGIS					= 0x85AA
//#	MAX_BLUE_SGIS					= 0x85AB
//#	MIN_ALPHA_SGIS					= 0x85AC
//#	MAX_ALPHA_SGIS					= 0x85AD
//
//###############################################################################
//
//# EXT_texture_perturb_normal enum:
//#	PERTURB_EXT					= 0x85AE
//#	TEXTURE_NORMAL_EXT				= 0x85AF
//
//###############################################################################
//
//# Apple: 0x85B0-0x85BF
//
//# APPLE_specular_vector enum:
//#	LIGHT_MODEL_SPECULAR_VECTOR_APPLE		= 0x85B0
//
//# APPLE_transform_hint enum:
//#	TRANSFORM_HINT_APPLE				= 0x85B1
//
//# APPLE_client_storage enum:
//#	UNPACK_CLIENT_STORAGE_APPLE			= 0x85B2
//
//# APPLE_future_use: 0x85B3-0x85B4
//## From Jeremy 2006/10/18 (Bugzilla bug 632) - unknown extension name
//#	BUFFER_OBJECT_APPLE				= 0x85B3
//#	STORAGE_CLIENT_APPLE				= 0x85B4
//
//# VERSION_3_0 enum:
//# ARB_vertex_array_object enum: (note: no ARB suffixes)
//# APPLE_vertex_array_object enum:
//#	VERTEX_ARRAY_BINDING				= 0x85B5	# 3.0 / ARB_vao
//#	VERTEX_ARRAY_BINDING_APPLE			= 0x85B5
//
//# APPLE_future_use: 0x85B6-0x85B8
//## From Jeremy 2006/10/18 (Bugzilla bug 632) - unknown extension name
//#	TEXTURE_MINIMIZE_STORAGE_APPLE			= 0x85B6
//#	TEXTURE_RANGE_LENGTH_APPLE			= 0x85B7
//#	TEXTURE_RANGE_POINTER_APPLE			= 0x85B8
//
//# APPLE_ycbcr_422 enum:
//# MESA_ycbcr_texture enum: (additional; see below)
//#	YCBCR_422_APPLE					= 0x85B9
//#	UNSIGNED_SHORT_8_8_APPLE			= 0x85BA
//#	UNSIGNED_SHORT_8_8_MESA				= 0x85BA
//#	UNSIGNED_SHORT_8_8_REV_APPLE			= 0x85BB
//#	UNSIGNED_SHORT_8_8_REV_MESA			= 0x85BB
//
//# MESA_ycbcr_texture enum: (separate; see below)
//#	UNSIGNED_SHORT_8_8_MESA				= 0x85BA
//#	UNSIGNED_SHORT_8_8_REV_MESA			= 0x85BB
//
//# APPLE_future_use: 0x85BC-0x85BD
//## From Jeremy 2006/10/18 (Bugzilla bug 632) - unknown extension name
//#	TEXTURE_STORAGE_HINT_APPLE			= 0x85BC
//#	STORAGE_PRIVATE_APPLE				= 0x85BD
//
//# APPLE_vertex_array_range (additional; see above): 0x85BE-0x85BF
//
//###############################################################################
//
//# Sun: 0x85C0-0x85CF
//
//# SUNX_general_triangle_list (additional; see above): 0x85C0-0x85CB
//
//# SUN_slice_accum: 0x85CC
//#	SLICE_ACCUM_SUN					= 0x85CC
//
//###############################################################################
//
//# Unknown extension name, not in enumext.spec
//# 3Dlabs/Autodesk: 0x85D0-0x85DF
//#	FACET_NORMAL_AUTODESK				= 0x85D0
//#	FACET_NORMAL_ARRAY_AUTODESK			= 0x85D1
//
//###############################################################################
//
//# Incomplete extension, not in enumext.spec
//# SGIX_texture_range: 0x85E0-0x85FB
//#	RGB_SIGNED_SGIX					= 0x85E0
//#	RGBA_SIGNED_SGIX				= 0x85E1
//#	ALPHA_SIGNED_SGIX				= 0x85E2
//#	LUMINANCE_SIGNED_SGIX				= 0x85E3
//#	INTENSITY_SIGNED_SGIX				= 0x85E4
//#	LUMINANCE_ALPHA_SIGNED_SGIX			= 0x85E5
//#	RGB16_SIGNED_SGIX				= 0x85E6
//#	RGBA16_SIGNED_SGIX				= 0x85E7
//#	ALPHA16_SIGNED_SGIX				= 0x85E8
//#	LUMINANCE16_SIGNED_SGIX				= 0x85E9
//#	INTENSITY16_SIGNED_SGIX				= 0x85EA
//#	LUMINANCE16_ALPHA16_SIGNED_SGIX			= 0x85EB
//#	RGB_EXTENDED_RANGE_SGIX				= 0x85EC
//#	RGBA_EXTENDED_RANGE_SGIX			= 0x85ED
//#	ALPHA_EXTENDED_RANGE_SGIX			= 0x85EE
//#	LUMINANCE_EXTENDED_RANGE_SGIX			= 0x85EF
//#	INTENSITY_EXTENDED_RANGE_SGIX			= 0x85F0
//#	LUMINANCE_ALPHA_EXTENDED_RANGE_SGIX		= 0x85F1
//#	RGB16_EXTENDED_RANGE_SGIX			= 0x85F2
//#	RGBA16_EXTENDED_RANGE_SGIX			= 0x85F3
//#	ALPHA16_EXTENDED_RANGE_SGIX			= 0x85F4
//#	LUMINANCE16_EXTENDED_RANGE_SGIX			= 0x85F5
//#	INTENSITY16_EXTENDED_RANGE_SGIX			= 0x85F6
//#	LUMINANCE16_ALPHA16_EXTENDED_RANGE_SGIX		= 0x85F7
//#	MIN_LUMINANCE_SGIS				= 0x85F8
//#	MAX_LUMINANCE_SGIS				= 0x85F9
//#	MIN_INTENSITY_SGIS				= 0x85FA
//#	MAX_INTENSITY_SGIS				= 0x85FB
//
//###############################################################################
//
//# SGI_future_use: 0x85FC-0x85FF
//
//###############################################################################
//
//# Sun: 0x8600-0x861F
//
//# SUN_mesh_array: 0x8614-0x8615
//#	QUAD_MESH_SUN					= 0x8614
//#	TRIANGLE_MESH_SUN				= 0x8615
//
//###############################################################################
//
//# NVIDIA: 0x8620-0x867F
//
//# NV_vertex_program enum:
//#	VERTEX_PROGRAM_NV				= 0x8620
//#	VERTEX_STATE_PROGRAM_NV				= 0x8621
//#	ATTRIB_ARRAY_SIZE_NV				= 0x8623
//#	ATTRIB_ARRAY_STRIDE_NV				= 0x8624
//#	ATTRIB_ARRAY_TYPE_NV				= 0x8625
//#	CURRENT_ATTRIB_NV				= 0x8626
//#	PROGRAM_LENGTH_NV				= 0x8627
//#	PROGRAM_STRING_NV				= 0x8628
//#	MODELVIEW_PROJECTION_NV				= 0x8629
//#	IDENTITY_NV					= 0x862A
//#	INVERSE_NV					= 0x862B
//#	TRANSPOSE_NV					= 0x862C
//#	INVERSE_TRANSPOSE_NV				= 0x862D
//#	MAX_TRACK_MATRIX_STACK_DEPTH_NV			= 0x862E
//#	MAX_TRACK_MATRICES_NV				= 0x862F
//#	MATRIX0_NV					= 0x8630
//#	MATRIX1_NV					= 0x8631
//#	MATRIX2_NV					= 0x8632
//#	MATRIX3_NV					= 0x8633
//#	MATRIX4_NV					= 0x8634
//#	MATRIX5_NV					= 0x8635
//#	MATRIX6_NV					= 0x8636
//#	MATRIX7_NV					= 0x8637
//# ##################
//# #
//# #	Reserved:
//# #
//# #	MATRIX8_NV					= 0x8638
//# #	MATRIX9_NV					= 0x8639
//# #	MATRIX10_NV					= 0x863A
//# #	MATRIX11_NV					= 0x863B
//# #	MATRIX12_NV					= 0x863C
//# #	MATRIX13_NV					= 0x863D
//# #	MATRIX14_NV					= 0x863E
//# #	MATRIX15_NV					= 0x863F
//# #
//# ###################
//#	CURRENT_MATRIX_STACK_DEPTH_NV			= 0x8640
//#	CURRENT_MATRIX_NV				= 0x8641
//#	VERTEX_PROGRAM_POINT_SIZE_NV			= 0x8642
//#	VERTEX_PROGRAM_TWO_SIDE_NV			= 0x8643
//#	PROGRAM_PARAMETER_NV				= 0x8644
//#	ATTRIB_ARRAY_POINTER_NV				= 0x8645
//#	PROGRAM_TARGET_NV				= 0x8646
//#	PROGRAM_RESIDENT_NV				= 0x8647
//#	TRACK_MATRIX_NV					= 0x8648
//#	TRACK_MATRIX_TRANSFORM_NV			= 0x8649
//#	VERTEX_PROGRAM_BINDING_NV			= 0x864A
//#	PROGRAM_ERROR_POSITION_NV			= 0x864B
//#	VERTEX_ATTRIB_ARRAY0_NV				= 0x8650
//#	VERTEX_ATTRIB_ARRAY1_NV				= 0x8651
//#	VERTEX_ATTRIB_ARRAY2_NV				= 0x8652
//#	VERTEX_ATTRIB_ARRAY3_NV				= 0x8653
//#	VERTEX_ATTRIB_ARRAY4_NV				= 0x8654
//#	VERTEX_ATTRIB_ARRAY5_NV				= 0x8655
//#	VERTEX_ATTRIB_ARRAY6_NV				= 0x8656
//#	VERTEX_ATTRIB_ARRAY7_NV				= 0x8657
//#	VERTEX_ATTRIB_ARRAY8_NV				= 0x8658
//#	VERTEX_ATTRIB_ARRAY9_NV				= 0x8659
//#	VERTEX_ATTRIB_ARRAY10_NV			= 0x865A
//#	VERTEX_ATTRIB_ARRAY11_NV			= 0x865B
//#	VERTEX_ATTRIB_ARRAY12_NV			= 0x865C
//#	VERTEX_ATTRIB_ARRAY13_NV			= 0x865D
//#	VERTEX_ATTRIB_ARRAY14_NV			= 0x865E
//#	VERTEX_ATTRIB_ARRAY15_NV			= 0x865F
//#	MAP1_VERTEX_ATTRIB0_4_NV			= 0x8660
//#	MAP1_VERTEX_ATTRIB1_4_NV			= 0x8661
//#	MAP1_VERTEX_ATTRIB2_4_NV			= 0x8662
//#	MAP1_VERTEX_ATTRIB3_4_NV			= 0x8663
//#	MAP1_VERTEX_ATTRIB4_4_NV			= 0x8664
//#	MAP1_VERTEX_ATTRIB5_4_NV			= 0x8665
//#	MAP1_VERTEX_ATTRIB6_4_NV			= 0x8666
//#	MAP1_VERTEX_ATTRIB7_4_NV			= 0x8667
//#	MAP1_VERTEX_ATTRIB8_4_NV			= 0x8668
//#	MAP1_VERTEX_ATTRIB9_4_NV			= 0x8669
//#	MAP1_VERTEX_ATTRIB10_4_NV			= 0x866A
//#	MAP1_VERTEX_ATTRIB11_4_NV			= 0x866B
//#	MAP1_VERTEX_ATTRIB12_4_NV			= 0x866C
//#	MAP1_VERTEX_ATTRIB13_4_NV			= 0x866D
//#	MAP1_VERTEX_ATTRIB14_4_NV			= 0x866E
//#	MAP1_VERTEX_ATTRIB15_4_NV			= 0x866F
//#	MAP2_VERTEX_ATTRIB0_4_NV			= 0x8670
//#	MAP2_VERTEX_ATTRIB1_4_NV			= 0x8671
//#	MAP2_VERTEX_ATTRIB2_4_NV			= 0x8672
//#	MAP2_VERTEX_ATTRIB3_4_NV			= 0x8673
//#	MAP2_VERTEX_ATTRIB4_4_NV			= 0x8674
//#	MAP2_VERTEX_ATTRIB5_4_NV			= 0x8675
//#	MAP2_VERTEX_ATTRIB6_4_NV			= 0x8676
//#	MAP2_VERTEX_ATTRIB7_4_NV			= 0x8677
//#	MAP2_VERTEX_ATTRIB8_4_NV			= 0x8678
//#	MAP2_VERTEX_ATTRIB9_4_NV			= 0x8679
//#	MAP2_VERTEX_ATTRIB10_4_NV			= 0x867A
//#	MAP2_VERTEX_ATTRIB11_4_NV			= 0x867B
//#	MAP2_VERTEX_ATTRIB12_4_NV			= 0x867C
//#	MAP2_VERTEX_ATTRIB13_4_NV			= 0x867D
//#	MAP2_VERTEX_ATTRIB14_4_NV			= 0x867E
//#	MAP2_VERTEX_ATTRIB15_4_NV			= 0x867F
//
//# NV_texture_shader (additional; see below): 0x864C-0x864E
//
//# ARB_geometry_shader4 enum: (additional; see below)
//# NV_geometry_program4 enum: (additional; see below)
//#	PROGRAM_POINT_SIZE_ARB				= 0x8642
//#	PROGRAM_POINT_SIZE_EXT				= 0x8642
//
//# NV_depth_clamp enum:
//#	DEPTH_CLAMP_NV					= 0x864F
//
//# VERSION_2_0 enum: (Promoted from ARB_vertex_shader; only some values)
//# ARB_vertex_program enum: (additional; see above; reuses NV_vertex_program values)
//# ARB_fragment_program enum: (additional; only some values; see below)
//# (Unfortunately, PROGRAM_BINDING_ARB does accidentally reuse 0x8677)
//#	VERTEX_PROGRAM_ARB				= 0x8620
//#	VERTEX_ATTRIB_ARRAY_ENABLED			= 0x8622    # VERSION_2_0
//#	VERTEX_ATTRIB_ARRAY_ENABLED_ARB			= 0x8622
//#	VERTEX_ATTRIB_ARRAY_SIZE			= 0x8623    # VERSION_2_0
//#	VERTEX_ATTRIB_ARRAY_SIZE_ARB			= 0x8623
//#	VERTEX_ATTRIB_ARRAY_STRIDE			= 0x8624    # VERSION_2_0
//#	VERTEX_ATTRIB_ARRAY_STRIDE_ARB			= 0x8624
//#	VERTEX_ATTRIB_ARRAY_TYPE			= 0x8625    # VERSION_2_0
//#	VERTEX_ATTRIB_ARRAY_TYPE_ARB			= 0x8625
//#	CURRENT_VERTEX_ATTRIB				= 0x8626    # VERSION_2_0
//#	CURRENT_VERTEX_ATTRIB_ARB			= 0x8626
//#	PROGRAM_LENGTH_ARB				= 0x8627    # ARB_fragment_program
//#	PROGRAM_STRING_ARB				= 0x8628    # ARB_fragment_program
//#	MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB		= 0x862E    # ARB_fragment_program
//#	MAX_PROGRAM_MATRICES_ARB			= 0x862F    # ARB_fragment_program
//#	CURRENT_MATRIX_STACK_DEPTH_ARB			= 0x8640    # ARB_fragment_program
//#	CURRENT_MATRIX_ARB				= 0x8641    # ARB_fragment_program
//#	VERTEX_PROGRAM_POINT_SIZE			= 0x8642    # VERSION_2_0
//#	VERTEX_PROGRAM_POINT_SIZE_ARB			= 0x8642
//#	VERTEX_PROGRAM_TWO_SIDE				= 0x8643    # VERSION_2_0
//#	VERTEX_PROGRAM_TWO_SIDE_ARB			= 0x8643
//#	VERTEX_ATTRIB_ARRAY_POINTER			= 0x8645    # VERSION_2_0
//#	VERTEX_ATTRIB_ARRAY_POINTER_ARB			= 0x8645
//#	PROGRAM_ERROR_POSITION_ARB			= 0x864B    # ARB_fragment_program
//#	PROGRAM_BINDING_ARB				= 0x8677    # ARB_fragment_program
//
//###############################################################################
//
//# Pixelfusion: 0x8680-0x869F
//
//###############################################################################
//
//# ARB: 0x86A0-0x86AF
//
//# ARB_texture_compression/1.3 (additional; see above): 0x86A0-0x86A3
//
//# ARB_vertex_blend enum:
//#	MAX_VERTEX_UNITS_ARB				= 0x86A4
//#	ACTIVE_VERTEX_UNITS_ARB				= 0x86A5
//#	WEIGHT_SUM_UNITY_ARB				= 0x86A6
//#	VERTEX_BLEND_ARB				= 0x86A7
//#	CURRENT_WEIGHT_ARB				= 0x86A8
//#	WEIGHT_ARRAY_TYPE_ARB				= 0x86A9
//#	WEIGHT_ARRAY_STRIDE_ARB				= 0x86AA
//#	WEIGHT_ARRAY_SIZE_ARB				= 0x86AB
//#	WEIGHT_ARRAY_POINTER_ARB			= 0x86AC
//#	WEIGHT_ARRAY_ARB				= 0x86AD
//# Note: MODELVIEW0/1 are defined in other extensions, but not as ARB)
//#	MODELVIEW0_ARB					= 0x1700
//#	MODELVIEW1_ARB					= 0x850A
//#	MODELVIEW2_ARB					= 0x8722
//#	MODELVIEW3_ARB					= 0x8723
//#	MODELVIEW4_ARB					= 0x8724
//#	MODELVIEW5_ARB					= 0x8725
//#	MODELVIEW6_ARB					= 0x8726
//#	MODELVIEW7_ARB					= 0x8727
//#	MODELVIEW8_ARB					= 0x8728
//#	MODELVIEW9_ARB					= 0x8729
//#	MODELVIEW10_ARB					= 0x872A
//#	MODELVIEW11_ARB					= 0x872B
//#	MODELVIEW12_ARB					= 0x872C
//#	MODELVIEW13_ARB					= 0x872D
//#	MODELVIEW14_ARB					= 0x872E
//#	MODELVIEW15_ARB					= 0x872F
//#	MODELVIEW16_ARB					= 0x8730
//#	MODELVIEW17_ARB					= 0x8731
//#	MODELVIEW18_ARB					= 0x8732
//#	MODELVIEW19_ARB					= 0x8733
//#	MODELVIEW20_ARB					= 0x8734
//#	MODELVIEW21_ARB					= 0x8735
//#	MODELVIEW22_ARB					= 0x8736
//#	MODELVIEW23_ARB					= 0x8737
//#	MODELVIEW24_ARB					= 0x8738
//#	MODELVIEW25_ARB					= 0x8739
//#	MODELVIEW26_ARB					= 0x873A
//#	MODELVIEW27_ARB					= 0x873B
//#	MODELVIEW28_ARB					= 0x873C
//#	MODELVIEW29_ARB					= 0x873D
//#	MODELVIEW30_ARB					= 0x873E
//#	MODELVIEW31_ARB					= 0x873F
//
//# VERSION_1_3 enum: (Promoted for OpenGL 1.3)
//# ARB_texture_env_dot3
//#	DOT3_RGB					= 0x86AE
//#	DOT3_RGB_ARB					= 0x86AE
//#	DOT3_RGBA					= 0x86AF
//#	DOT3_RGBA_ARB					= 0x86AF
//
//###############################################################################
//
//# 3Dfx: 0x86B0-0x86BF
//
//# 3DFX_texture_compression_FXT1 enum:
//#	COMPRESSED_RGB_FXT1_3DFX			= 0x86B0
//#	COMPRESSED_RGBA_FXT1_3DFX			= 0x86B1
//
//# 3DFX_multisample enum:
//#	MULTISAMPLE_3DFX				= 0x86B2
//#	SAMPLE_BUFFERS_3DFX				= 0x86B3
//#	SAMPLES_3DFX					= 0x86B4
//#	MULTISAMPLE_BIT_3DFX				= 0x20000000
//
//###############################################################################
//
//# NVIDIA: 0x86C0-0x871F
//
//# NV_evaluators enum:
//#	EVAL_2D_NV					= 0x86C0
//#	EVAL_TRIANGULAR_2D_NV				= 0x86C1
//#	MAP_TESSELLATION_NV				= 0x86C2
//#	MAP_ATTRIB_U_ORDER_NV				= 0x86C3
//#	MAP_ATTRIB_V_ORDER_NV				= 0x86C4
//#	EVAL_FRACTIONAL_TESSELLATION_NV			= 0x86C5
//#	EVAL_VERTEX_ATRRIB0_NV				= 0x86C6
//#	EVAL_VERTEX_ATRRIB1_NV				= 0x86C7
//#	EVAL_VERTEX_ATRRIB2_NV				= 0x86C8
//#	EVAL_VERTEX_ATRRIB3_NV				= 0x86C9
//#	EVAL_VERTEX_ATRRIB4_NV				= 0x86CA
//#	EVAL_VERTEX_ATRRIB5_NV				= 0x86CB
//#	EVAL_VERTEX_ATRRIB6_NV				= 0x86CC
//#	EVAL_VERTEX_ATRRIB7_NV				= 0x86CD
//#	EVAL_VERTEX_ATRRIB8_NV				= 0x86CE
//#	EVAL_VERTEX_ATRRIB9_NV				= 0x86CF
//#	EVAL_VERTEX_ATRRIB10_NV				= 0x86D0
//#	EVAL_VERTEX_ATRRIB11_NV				= 0x86D1
//#	EVAL_VERTEX_ATRRIB12_NV				= 0x86D2
//#	EVAL_VERTEX_ATRRIB13_NV				= 0x86D3
//#	EVAL_VERTEX_ATRRIB14_NV				= 0x86D4
//#	EVAL_VERTEX_ATRRIB15_NV				= 0x86D5
//#	MAX_MAP_TESSELLATION_NV				= 0x86D6
//#	MAX_RATIONAL_EVAL_ORDER_NV			= 0x86D7
//
//# NV_future_use: 0x86D8
//
//# NV_texture_shader enum:
//#	OFFSET_TEXTURE_RECTANGLE_NV			= 0x864C
//#	OFFSET_TEXTURE_RECTANGLE_SCALE_NV		= 0x864D
//#	DOT_PRODUCT_TEXTURE_RECTANGLE_NV		= 0x864E
//#	RGBA_UNSIGNED_DOT_PRODUCT_MAPPING_NV		= 0x86D9
//#	UNSIGNED_INT_S8_S8_8_8_NV			= 0x86DA
//#	UNSIGNED_INT_8_8_S8_S8_REV_NV			= 0x86DB
//#	DSDT_MAG_INTENSITY_NV				= 0x86DC
//#	SHADER_CONSISTENT_NV				= 0x86DD
//#	TEXTURE_SHADER_NV				= 0x86DE
//#	SHADER_OPERATION_NV				= 0x86DF
//#	CULL_MODES_NV					= 0x86E0
//#	OFFSET_TEXTURE_MATRIX_NV			= 0x86E1
//#	OFFSET_TEXTURE_SCALE_NV				= 0x86E2
//#	OFFSET_TEXTURE_BIAS_NV				= 0x86E3
//#	OFFSET_TEXTURE_2D_MATRIX_NV			= GL_OFFSET_TEXTURE_MATRIX_NV
//#	OFFSET_TEXTURE_2D_SCALE_NV			= GL_OFFSET_TEXTURE_SCALE_NV
//#	OFFSET_TEXTURE_2D_BIAS_NV			= GL_OFFSET_TEXTURE_BIAS_NV
//#	PREVIOUS_TEXTURE_INPUT_NV			= 0x86E4
//#	CONST_EYE_NV					= 0x86E5
//#	PASS_THROUGH_NV					= 0x86E6
//#	CULL_FRAGMENT_NV				= 0x86E7
//#	OFFSET_TEXTURE_2D_NV				= 0x86E8
//#	DEPENDENT_AR_TEXTURE_2D_NV			= 0x86E9
//#	DEPENDENT_GB_TEXTURE_2D_NV			= 0x86EA
//#	DOT_PRODUCT_NV					= 0x86EC
//#	DOT_PRODUCT_DEPTH_REPLACE_NV			= 0x86ED
//#	DOT_PRODUCT_TEXTURE_2D_NV			= 0x86EE
//#	DOT_PRODUCT_TEXTURE_CUBE_MAP_NV			= 0x86F0
//#	DOT_PRODUCT_DIFFUSE_CUBE_MAP_NV			= 0x86F1
//#	DOT_PRODUCT_REFLECT_CUBE_MAP_NV			= 0x86F2
//#	DOT_PRODUCT_CONST_EYE_REFLECT_CUBE_MAP_NV	= 0x86F3
//#	HILO_NV						= 0x86F4
//#	DSDT_NV						= 0x86F5
//#	DSDT_MAG_NV					= 0x86F6
//#	DSDT_MAG_VIB_NV					= 0x86F7
//#	HILO16_NV					= 0x86F8
//#	SIGNED_HILO_NV					= 0x86F9
//#	SIGNED_HILO16_NV				= 0x86FA
//#	SIGNED_RGBA_NV					= 0x86FB
//#	SIGNED_RGBA8_NV					= 0x86FC
//#	SIGNED_RGB_NV					= 0x86FE
//#	SIGNED_RGB8_NV					= 0x86FF
//#	SIGNED_LUMINANCE_NV				= 0x8701
//#	SIGNED_LUMINANCE8_NV				= 0x8702
//#	SIGNED_LUMINANCE_ALPHA_NV			= 0x8703
//#	SIGNED_LUMINANCE8_ALPHA8_NV			= 0x8704
//#	SIGNED_ALPHA_NV					= 0x8705
//#	SIGNED_ALPHA8_NV				= 0x8706
//#	SIGNED_INTENSITY_NV				= 0x8707
//#	SIGNED_INTENSITY8_NV				= 0x8708
//#	DSDT8_NV					= 0x8709
//#	DSDT8_MAG8_NV					= 0x870A
//#	DSDT8_MAG8_INTENSITY8_NV			= 0x870B
//#	SIGNED_RGB_UNSIGNED_ALPHA_NV			= 0x870C
//#	SIGNED_RGB8_UNSIGNED_ALPHA8_NV			= 0x870D
//#	HI_SCALE_NV					= 0x870E
//#	LO_SCALE_NV					= 0x870F
//#	DS_SCALE_NV					= 0x8710
//#	DT_SCALE_NV					= 0x8711
//#	MAGNITUDE_SCALE_NV				= 0x8712
//#	VIBRANCE_SCALE_NV				= 0x8713
//#	HI_BIAS_NV					= 0x8714
//#	LO_BIAS_NV					= 0x8715
//#	DS_BIAS_NV					= 0x8716
//#	DT_BIAS_NV					= 0x8717
//#	MAGNITUDE_BIAS_NV				= 0x8718
//#	VIBRANCE_BIAS_NV				= 0x8719
//#	TEXTURE_BORDER_VALUES_NV			= 0x871A
//#	TEXTURE_HI_SIZE_NV				= 0x871B
//#	TEXTURE_LO_SIZE_NV				= 0x871C
//#	TEXTURE_DS_SIZE_NV				= 0x871D
//#	TEXTURE_DT_SIZE_NV				= 0x871E
//#	TEXTURE_MAG_SIZE_NV				= 0x871F
//
//# NV_texture_shader2 enum:
//#	DOT_PRODUCT_TEXTURE_3D_NV			= 0x86EF
//
//# NV_future_use: 0x86EB
//# NV_future_use: 0x86FD
//# NV_future_use: 0x8700
//
//###############################################################################
//
//# ARB: 0x8720-0x873F
//
//# ARB_vertex_blend (additional; see above): 0x8720-0x873F
//
//###############################################################################
//
//# ATI: 0x8740-0x874F
//
//# EXT_texture_env_dot3 enum:
//#	DOT3_RGB_EXT					= 0x8740
//#	DOT3_RGBA_EXT					= 0x8741
//
//# ATI_texture_mirror_once enum:
//#	MIRROR_CLAMP_ATI				= 0x8742
//#	MIRROR_CLAMP_TO_EDGE_ATI			= 0x8743
//# EXT_texture_mirror_clamp enum:
//#	MIRROR_CLAMP_EXT				= 0x8742
//#	MIRROR_CLAMP_TO_EDGE_EXT			= 0x8743
//
//# ATI_texture_env_combine3 enum:
//#	MODULATE_ADD_ATI				= 0x8744
//#	MODULATE_SIGNED_ADD_ATI				= 0x8745
//#	MODULATE_SUBTRACT_ATI				= 0x8746
//
//# ATI_future_use: 0x8747-0x874F
//
//###############################################################################
//
//# MESA: 0x8750-0x875F
//
//# MESA_packed_depth_stencil enum:
//#	DEPTH_STENCIL_MESA				= 0x8750
//#	UNSIGNED_INT_24_8_MESA				= 0x8751
//#	UNSIGNED_INT_8_24_REV_MESA			= 0x8752
//#	UNSIGNED_SHORT_15_1_MESA			= 0x8753
//#	UNSIGNED_SHORT_1_15_REV_MESA			= 0x8754
//
//# MESA_trace enum:
//#	TRACE_ALL_BITS_MESA				= 0xFFFF
//#	TRACE_OPERATIONS_BIT_MESA			= 0x0001
//#	TRACE_PRIMITIVES_BIT_MESA			= 0x0002
//#	TRACE_ARRAYS_BIT_MESA				= 0x0004
//#	TRACE_TEXTURES_BIT_MESA				= 0x0008
//#	TRACE_PIXELS_BIT_MESA				= 0x0010
//#	TRACE_ERRORS_BIT_MESA				= 0x0020
//#	TRACE_MASK_MESA					= 0x8755
//#	TRACE_NAME_MESA					= 0x8756
//
//# MESA_ycbcr_texture enum:
//#	YCBCR_MESA					= 0x8757
//
//# MESA_pack_invert enum:
//#	PACK_INVERT_MESA				= 0x8758
//
//# MESAX_texture_stack enum:
//#	TEXTURE_1D_STACK_MESAX				= 0x8759
//#	TEXTURE_2D_STACK_MESAX				= 0x875A
//#	PROXY_TEXTURE_1D_STACK_MESAX			= 0x875B
//#	PROXY_TEXTURE_2D_STACK_MESAX			= 0x875C
//#	TEXTURE_1D_STACK_BINDING_MESAX			= 0x875D
//#	TEXTURE_2D_STACK_BINDING_MESAX			= 0x875E
//
//# MESA_shader_debug enum:
//#	DEBUG_OBJECT_MESA				= 0x8759
//#	DEBUG_PRINT_MESA				= 0x875A
//#	DEBUG_ASSERT_MESA				= 0x875B
//
//
//# MESA_future_use: 0x875F
//
//###############################################################################
//
//# ATI: 0x8760-0x883F
//
//# ATI_vertex_array_object enum:
//#	STATIC_ATI					= 0x8760
//#	DYNAMIC_ATI					= 0x8761
//#	PRESERVE_ATI					= 0x8762
//#	DISCARD_ATI					= 0x8763
//#	OBJECT_BUFFER_SIZE_ATI				= 0x8764
//#	OBJECT_BUFFER_USAGE_ATI				= 0x8765
//#	ARRAY_OBJECT_BUFFER_ATI				= 0x8766
//#	ARRAY_OBJECT_OFFSET_ATI				= 0x8767
//
//# VERSION_1_5 enum: (Promoted for OpenGL 1.5)
//# ARB_vertex_buffer_object enum (additional; aliases some ATI enums; see below)
//#	BUFFER_SIZE					= 0x8764
//#	BUFFER_SIZE_ARB					= 0x8764
//#	BUFFER_USAGE					= 0x8765
//#	BUFFER_USAGE_ARB				= 0x8765
//
//# ATI_element_array enum:
//#	ELEMENT_ARRAY_ATI				= 0x8768
//#	ELEMENT_ARRAY_TYPE_ATI				= 0x8769
//#	ELEMENT_ARRAY_POINTER_ATI			= 0x876A
//
//# @@@ (extends ATI_element_array, I think???)
//# APPLE_element_array enum:
//#	ELEMENT_ARRAY_APPLE				= 0x8768
//#	ELEMENT_ARRAY_TYPE_APPLE			= 0x8769
//#	ELEMENT_ARRAY_POINTER_APPLE			= 0x876A
//
//# ATI_vertex_streams enum:
//#	MAX_VERTEX_STREAMS_ATI				= 0x876B
//#	VERTEX_STREAM0_ATI				= 0x876C
//#	VERTEX_STREAM1_ATI				= 0x876D
//#	VERTEX_STREAM2_ATI				= 0x876E
//#	VERTEX_STREAM3_ATI				= 0x876F
//#	VERTEX_STREAM4_ATI				= 0x8770
//#	VERTEX_STREAM5_ATI				= 0x8771
//#	VERTEX_STREAM6_ATI				= 0x8772
//#	VERTEX_STREAM7_ATI				= 0x8773
//#	VERTEX_SOURCE_ATI				= 0x8774
//
//# ATI_envmap_bumpmap enum:
//#	BUMP_ROT_MATRIX_ATI				= 0x8775
//#	BUMP_ROT_MATRIX_SIZE_ATI			= 0x8776
//#	BUMP_NUM_TEX_UNITS_ATI				= 0x8777
//#	BUMP_TEX_UNITS_ATI				= 0x8778
//#	DUDV_ATI					= 0x8779
//#	DU8DV8_ATI					= 0x877A
//#	BUMP_ENVMAP_ATI					= 0x877B
//#	BUMP_TARGET_ATI					= 0x877C
//
//# ATI_future_use: 0x877D-0x877F
//
//# EXT_vertex_shader enum:
//#	VERTEX_SHADER_EXT				= 0x8780
//#	VERTEX_SHADER_BINDING_EXT			= 0x8781
//#	OP_INDEX_EXT					= 0x8782
//#	OP_NEGATE_EXT					= 0x8783
//#	OP_DOT3_EXT					= 0x8784
//#	OP_DOT4_EXT					= 0x8785
//#	OP_MUL_EXT					= 0x8786
//#	OP_ADD_EXT					= 0x8787
//#	OP_MADD_EXT					= 0x8788
//#	OP_FRAC_EXT					= 0x8789
//#	OP_MAX_EXT					= 0x878A
//#	OP_MIN_EXT					= 0x878B
//#	OP_SET_GE_EXT					= 0x878C
//#	OP_SET_LT_EXT					= 0x878D
//#	OP_CLAMP_EXT					= 0x878E
//#	OP_FLOOR_EXT					= 0x878F
//#	OP_ROUND_EXT					= 0x8790
//#	OP_EXP_BASE_2_EXT				= 0x8791
//#	OP_LOG_BASE_2_EXT				= 0x8792
//#	OP_POWER_EXT					= 0x8793
//#	OP_RECIP_EXT					= 0x8794
//#	OP_RECIP_SQRT_EXT				= 0x8795
//#	OP_SUB_EXT					= 0x8796
//#	OP_CROSS_PRODUCT_EXT				= 0x8797
//#	OP_MULTIPLY_MATRIX_EXT				= 0x8798
//#	OP_MOV_EXT					= 0x8799
//#	OUTPUT_VERTEX_EXT				= 0x879A
//#	OUTPUT_COLOR0_EXT				= 0x879B
//#	OUTPUT_COLOR1_EXT				= 0x879C
//#	OUTPUT_TEXTURE_COORD0_EXT			= 0x879D
//#	OUTPUT_TEXTURE_COORD1_EXT			= 0x879E
//#	OUTPUT_TEXTURE_COORD2_EXT			= 0x879F
//#	OUTPUT_TEXTURE_COORD3_EXT			= 0x87A0
//#	OUTPUT_TEXTURE_COORD4_EXT			= 0x87A1
//#	OUTPUT_TEXTURE_COORD5_EXT			= 0x87A2
//#	OUTPUT_TEXTURE_COORD6_EXT			= 0x87A3
//#	OUTPUT_TEXTURE_COORD7_EXT			= 0x87A4
//#	OUTPUT_TEXTURE_COORD8_EXT			= 0x87A5
//#	OUTPUT_TEXTURE_COORD9_EXT			= 0x87A6
//#	OUTPUT_TEXTURE_COORD10_EXT			= 0x87A7
//#	OUTPUT_TEXTURE_COORD11_EXT			= 0x87A8
//#	OUTPUT_TEXTURE_COORD12_EXT			= 0x87A9
//#	OUTPUT_TEXTURE_COORD13_EXT			= 0x87AA
//#	OUTPUT_TEXTURE_COORD14_EXT			= 0x87AB
//#	OUTPUT_TEXTURE_COORD15_EXT			= 0x87AC
//#	OUTPUT_TEXTURE_COORD16_EXT			= 0x87AD
//#	OUTPUT_TEXTURE_COORD17_EXT			= 0x87AE
//#	OUTPUT_TEXTURE_COORD18_EXT			= 0x87AF
//#	OUTPUT_TEXTURE_COORD19_EXT			= 0x87B0
//#	OUTPUT_TEXTURE_COORD20_EXT			= 0x87B1
//#	OUTPUT_TEXTURE_COORD21_EXT			= 0x87B2
//#	OUTPUT_TEXTURE_COORD22_EXT			= 0x87B3
//#	OUTPUT_TEXTURE_COORD23_EXT			= 0x87B4
//#	OUTPUT_TEXTURE_COORD24_EXT			= 0x87B5
//#	OUTPUT_TEXTURE_COORD25_EXT			= 0x87B6
//#	OUTPUT_TEXTURE_COORD26_EXT			= 0x87B7
//#	OUTPUT_TEXTURE_COORD27_EXT			= 0x87B8
//#	OUTPUT_TEXTURE_COORD28_EXT			= 0x87B9
//#	OUTPUT_TEXTURE_COORD29_EXT			= 0x87BA
//#	OUTPUT_TEXTURE_COORD30_EXT			= 0x87BB
//#	OUTPUT_TEXTURE_COORD31_EXT			= 0x87BC
//#	OUTPUT_FOG_EXT					= 0x87BD
//#	SCALAR_EXT					= 0x87BE
//#	VECTOR_EXT					= 0x87BF
//#	MATRIX_EXT					= 0x87C0
//#	VARIANT_EXT					= 0x87C1
//#	INVARIANT_EXT					= 0x87C2
//#	LOCAL_CONSTANT_EXT				= 0x87C3
//#	LOCAL_EXT					= 0x87C4
//#	MAX_VERTEX_SHADER_INSTRUCTIONS_EXT		= 0x87C5
//#	MAX_VERTEX_SHADER_VARIANTS_EXT			= 0x87C6
//#	MAX_VERTEX_SHADER_INVARIANTS_EXT		= 0x87C7
//#	MAX_VERTEX_SHADER_LOCAL_CONSTANTS_EXT		= 0x87C8
//#	MAX_VERTEX_SHADER_LOCALS_EXT			= 0x87C9
//#	MAX_OPTIMIZED_VERTEX_SHADER_INSTRUCTIONS_EXT	= 0x87CA
//#	MAX_OPTIMIZED_VERTEX_SHADER_VARIANTS_EXT	= 0x87CB
//#	MAX_OPTIMIZED_VERTEX_SHADER_LOCAL_CONSTANTS_EXT = 0x87CC
//#	MAX_OPTIMIZED_VERTEX_SHADER_INVARIANTS_EXT	= 0x87CD
//#	MAX_OPTIMIZED_VERTEX_SHADER_LOCALS_EXT		= 0x87CE
//#	VERTEX_SHADER_INSTRUCTIONS_EXT			= 0x87CF
//#	VERTEX_SHADER_VARIANTS_EXT			= 0x87D0
//#	VERTEX_SHADER_INVARIANTS_EXT			= 0x87D1
//#	VERTEX_SHADER_LOCAL_CONSTANTS_EXT		= 0x87D2
//#	VERTEX_SHADER_LOCALS_EXT			= 0x87D3
//#	VERTEX_SHADER_OPTIMIZED_EXT			= 0x87D4
//#	X_EXT						= 0x87D5
//#	Y_EXT						= 0x87D6
//#	Z_EXT						= 0x87D7
//#	W_EXT						= 0x87D8
//#	NEGATIVE_X_EXT					= 0x87D9
//#	NEGATIVE_Y_EXT					= 0x87DA
//#	NEGATIVE_Z_EXT					= 0x87DB
//#	NEGATIVE_W_EXT					= 0x87DC
//#	ZERO_EXT					= 0x87DD
//#	ONE_EXT						= 0x87DE
//#	NEGATIVE_ONE_EXT				= 0x87DF
//#	NORMALIZED_RANGE_EXT				= 0x87E0
//#	FULL_RANGE_EXT					= 0x87E1
//#	CURRENT_VERTEX_EXT				= 0x87E2
//#	MVP_MATRIX_EXT					= 0x87E3
//#	VARIANT_VALUE_EXT				= 0x87E4
//#	VARIANT_DATATYPE_EXT				= 0x87E5
//#	VARIANT_ARRAY_STRIDE_EXT			= 0x87E6
//#	VARIANT_ARRAY_TYPE_EXT				= 0x87E7
//#	VARIANT_ARRAY_EXT				= 0x87E8
//#	VARIANT_ARRAY_POINTER_EXT			= 0x87E9
//#	INVARIANT_VALUE_EXT				= 0x87EA
//#	INVARIANT_DATATYPE_EXT				= 0x87EB
//#	LOCAL_CONSTANT_VALUE_EXT			= 0x87EC
//#	LOCAL_CONSTANT_DATATYPE_EXT			= 0x87ED
//
//# ATI_pn_triangles enum:
//#	PN_TRIANGLES_ATI				= 0x87F0
//#	MAX_PN_TRIANGLES_TESSELATION_LEVEL_ATI		= 0x87F1
//#	PN_TRIANGLES_POINT_MODE_ATI			= 0x87F2
//#	PN_TRIANGLES_NORMAL_MODE_ATI			= 0x87F3
//#	PN_TRIANGLES_TESSELATION_LEVEL_ATI		= 0x87F4
//#	PN_TRIANGLES_POINT_MODE_LINEAR_ATI		= 0x87F5
//#	PN_TRIANGLES_POINT_MODE_CUBIC_ATI		= 0x87F6
//#	PN_TRIANGLES_NORMAL_MODE_LINEAR_ATI		= 0x87F7
//#	PN_TRIANGLES_NORMAL_MODE_QUADRATIC_ATI		= 0x87F8
//
//# ATI_future_use: 0x87F9-0x87FF
//
//# VERSION_2_0 enum: (Promoted for OpenGL 2.0)
//# ATI_separate_stencil enum:
//#	STENCIL_BACK_FUNC				= 0x8800    # VERSION_2_0
//#	STENCIL_BACK_FUNC_ATI				= 0x8800
//#	STENCIL_BACK_FAIL				= 0x8801    # VERSION_2_0
//#	STENCIL_BACK_FAIL_ATI				= 0x8801
//#	STENCIL_BACK_PASS_DEPTH_FAIL			= 0x8802    # VERSION_2_0
//#	STENCIL_BACK_PASS_DEPTH_FAIL_ATI		= 0x8802
//#	STENCIL_BACK_PASS_DEPTH_PASS			= 0x8803    # VERSION_2_0
//#	STENCIL_BACK_PASS_DEPTH_PASS_ATI		= 0x8803
//
//# ARB_fragment_program enum:
//#	FRAGMENT_PROGRAM_ARB				= 0x8804
//#	PROGRAM_ALU_INSTRUCTIONS_ARB			= 0x8805
//#	PROGRAM_TEX_INSTRUCTIONS_ARB			= 0x8806
//#	PROGRAM_TEX_INDIRECTIONS_ARB			= 0x8807
//#	PROGRAM_NATIVE_ALU_INSTRUCTIONS_ARB		= 0x8808
//#	PROGRAM_NATIVE_TEX_INSTRUCTIONS_ARB		= 0x8809
//#	PROGRAM_NATIVE_TEX_INDIRECTIONS_ARB		= 0x880A
//#	MAX_PROGRAM_ALU_INSTRUCTIONS_ARB		= 0x880B
//#	MAX_PROGRAM_TEX_INSTRUCTIONS_ARB		= 0x880C
//#	MAX_PROGRAM_TEX_INDIRECTIONS_ARB		= 0x880D
//#	MAX_PROGRAM_NATIVE_ALU_INSTRUCTIONS_ARB		= 0x880E
//#	MAX_PROGRAM_NATIVE_TEX_INSTRUCTIONS_ARB		= 0x880F
//#	MAX_PROGRAM_NATIVE_TEX_INDIRECTIONS_ARB		= 0x8810
//
//# ATI_future_use: 0x8811-0x8813
//
//# VERSION_3_0 enum:
//# ARB_texture_float enum:
//# ATI_texture_float enum:
//#	RGBA32F						= 0x8814	# 3.0
//#	RGBA32F_ARB					= 0x8814
//#	RGBA_FLOAT32_ATI				= 0x8814
//#	RGB32F						= 0x8815	# 3.0
//#	RGB32F_ARB					= 0x8815
//#	RGB_FLOAT32_ATI					= 0x8815
//#	ALPHA32F_ARB					= 0x8816
//#	ALPHA_FLOAT32_ATI				= 0x8816
//#	INTENSITY32F_ARB				= 0x8817
//#	INTENSITY_FLOAT32_ATI				= 0x8817
//#	LUMINANCE32F_ARB				= 0x8818
//#	LUMINANCE_FLOAT32_ATI				= 0x8818
//#	LUMINANCE_ALPHA32F_ARB				= 0x8819
//#	LUMINANCE_ALPHA_FLOAT32_ATI			= 0x8819
//#	RGBA16F						= 0x881A	# 3.0
//#	RGBA16F_ARB					= 0x881A
//#	RGBA_FLOAT16_ATI				= 0x881A
//#	RGB16F						= 0x881B	# 3.0
//#	RGB16F_ARB					= 0x881B
//#	RGB_FLOAT16_ATI					= 0x881B
//#	ALPHA16F_ARB					= 0x881C
//#	ALPHA_FLOAT16_ATI				= 0x881C
//#	INTENSITY16F_ARB				= 0x881D
//#	INTENSITY_FLOAT16_ATI				= 0x881D
//#	LUMINANCE16F_ARB				= 0x881E
//#	LUMINANCE_FLOAT16_ATI				= 0x881E
//#	LUMINANCE_ALPHA16F_ARB				= 0x881F
//#	LUMINANCE_ALPHA_FLOAT16_ATI			= 0x881F
//
//# ARB_color_buffer_float enum:
//# ATI_pixel_format_float enum: (really WGL_ATI_pixel_format_float)
//#	RGBA_FLOAT_MODE_ARB				= 0x8820
//#	TYPE_RGBA_FLOAT_ATI				= 0x8820
//
//# ATI_future_use: 0x8821-0x8823
//
//# VERSION_2_0 enum: (Promoted for OpenGL 2.0)
//# ARB_draw_buffers enum:
//# ATI_draw_buffers enum:
//#	MAX_DRAW_BUFFERS				= 0x8824    # VERSION_2_0
//#	MAX_DRAW_BUFFERS_ARB				= 0x8824
//#	MAX_DRAW_BUFFERS_ATI				= 0x8824
//#	DRAW_BUFFER0					= 0x8825    # VERSION_2_0
//#	DRAW_BUFFER0_ARB				= 0x8825
//#	DRAW_BUFFER0_ATI				= 0x8825
//#	DRAW_BUFFER1					= 0x8826    # VERSION_2_0
//#	DRAW_BUFFER1_ARB				= 0x8826
//#	DRAW_BUFFER1_ATI				= 0x8826
//#	DRAW_BUFFER2					= 0x8827    # VERSION_2_0
//#	DRAW_BUFFER2_ARB				= 0x8827
//#	DRAW_BUFFER2_ATI				= 0x8827
//#	DRAW_BUFFER3					= 0x8828    # VERSION_2_0
//#	DRAW_BUFFER3_ARB				= 0x8828
//#	DRAW_BUFFER3_ATI				= 0x8828
//#	DRAW_BUFFER4					= 0x8829    # VERSION_2_0
//#	DRAW_BUFFER4_ARB				= 0x8829
//#	DRAW_BUFFER4_ATI				= 0x8829
//#	DRAW_BUFFER5					= 0x882A    # VERSION_2_0
//#	DRAW_BUFFER5_ARB				= 0x882A
//#	DRAW_BUFFER5_ATI				= 0x882A
//#	DRAW_BUFFER6					= 0x882B    # VERSION_2_0
//#	DRAW_BUFFER6_ARB				= 0x882B
//#	DRAW_BUFFER6_ATI				= 0x882B
//#	DRAW_BUFFER7					= 0x882C    # VERSION_2_0
//#	DRAW_BUFFER7_ARB				= 0x882C
//#	DRAW_BUFFER7_ATI				= 0x882C
//#	DRAW_BUFFER8					= 0x882D    # VERSION_2_0
//#	DRAW_BUFFER8_ARB				= 0x882D
//#	DRAW_BUFFER8_ATI				= 0x882D
//#	DRAW_BUFFER9					= 0x882E    # VERSION_2_0
//#	DRAW_BUFFER9_ARB				= 0x882E
//#	DRAW_BUFFER9_ATI				= 0x882E
//#	DRAW_BUFFER10					= 0x882F    # VERSION_2_0
//#	DRAW_BUFFER10_ARB				= 0x882F
//#	DRAW_BUFFER10_ATI				= 0x882F
//#	DRAW_BUFFER11					= 0x8830    # VERSION_2_0
//#	DRAW_BUFFER11_ARB				= 0x8830
//#	DRAW_BUFFER11_ATI				= 0x8830
//#	DRAW_BUFFER12					= 0x8831    # VERSION_2_0
//#	DRAW_BUFFER12_ARB				= 0x8831
//#	DRAW_BUFFER12_ATI				= 0x8831
//#	DRAW_BUFFER13					= 0x8832    # VERSION_2_0
//#	DRAW_BUFFER13_ARB				= 0x8832
//#	DRAW_BUFFER13_ATI				= 0x8832
//#	DRAW_BUFFER14					= 0x8833    # VERSION_2_0
//#	DRAW_BUFFER14_ARB				= 0x8833
//#	DRAW_BUFFER14_ATI				= 0x8833
//#	DRAW_BUFFER15					= 0x8834    # VERSION_2_0
//#	DRAW_BUFFER15_ARB				= 0x8834
//#	DRAW_BUFFER15_ATI				= 0x8834
//
//# ATI_pixel_format_float enum: (really WGL_ATI_pixel_format_float) (additional; see above)
//#	COLOR_CLEAR_UNCLAMPED_VALUE_ATI			= 0x8835
//
//# ATI_future_use: 0x8836-0x883F
//
//# VERSION_2_0 enum: (Promoted for OpenGL 2.0)
//# EXT_blend_equation_separate enum:
//#	BLEND_EQUATION_ALPHA				= 0x883D    # VERSION_2_0
//#	BLEND_EQUATION_ALPHA_EXT			= 0x883D
//
//###############################################################################
//
//# ARB: 0x8840-0x884F
//
//# ARB_matrix_palette enum:
//#	MATRIX_PALETTE_ARB				= 0x8840
//#	MAX_MATRIX_PALETTE_STACK_DEPTH_ARB		= 0x8841
//#	MAX_PALETTE_MATRICES_ARB			= 0x8842
//#	CURRENT_PALETTE_MATRIX_ARB			= 0x8843
//#	MATRIX_INDEX_ARRAY_ARB				= 0x8844
//#	CURRENT_MATRIX_INDEX_ARB			= 0x8845
//#	MATRIX_INDEX_ARRAY_SIZE_ARB			= 0x8846
//#	MATRIX_INDEX_ARRAY_TYPE_ARB			= 0x8847
//#	MATRIX_INDEX_ARRAY_STRIDE_ARB			= 0x8848
//#	MATRIX_INDEX_ARRAY_POINTER_ARB			= 0x8849
//
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# ARB_depth_texture enum:
//#	TEXTURE_DEPTH_SIZE				= 0x884A
//#	TEXTURE_DEPTH_SIZE_ARB				= 0x884A
//#	DEPTH_TEXTURE_MODE				= 0x884B
//#	DEPTH_TEXTURE_MODE_ARB				= 0x884B
//
//# VERSION_3_0 enum: (aliases)
//# VERSION_1_4 enum: (Promoted for OpenGL 1.4)
//# ARB_shadow enum:
//# EXT_texture_array enum: (additional; see below)
//#	TEXTURE_COMPARE_MODE				= 0x884C
//#	TEXTURE_COMPARE_MODE_ARB			= 0x884C
//#	TEXTURE_COMPARE_FUNC				= 0x884D
//#	TEXTURE_COMPARE_FUNC_ARB			= 0x884D
//#	COMPARE_REF_TO_TEXTURE				= GL_COMPARE_R_TO_TEXTURE_ARB	# 3.0
//#	COMPARE_R_TO_TEXTURE				= 0x884E
//#	COMPARE_R_TO_TEXTURE_ARB			= 0x884E
//#	COMPARE_REF_DEPTH_TO_TEXTURE_EXT		= 0x884E
//
//# ARB_future_use: 0x884F
//
//###############################################################################
//
//# NVIDIA: 0x8850-0x891F
//
//# NV_texture_shader3 enum:
//#	OFFSET_PROJECTIVE_TEXTURE_2D_NV			= 0x8850
//#	OFFSET_PROJECTIVE_TEXTURE_2D_SCALE_NV		= 0x8851
//#	OFFSET_PROJECTIVE_TEXTURE_RECTANGLE_NV		= 0x8852
//#	OFFSET_PROJECTIVE_TEXTURE_RECTANGLE_SCALE_NV	= 0x8853
//#	OFFSET_HILO_TEXTURE_2D_NV			= 0x8854
//#	OFFSET_HILO_TEXTURE_RECTANGLE_NV		= 0x8855
//#	OFFSET_HILO_PROJECTIVE_TEXTURE_2D_NV		= 0x8856
//#	OFFSET_HILO_PROJECTIVE_TEXTURE_RECTANGLE_NV	= 0x8857
//#	DEPENDENT_HILO_TEXTURE_2D_NV			= 0x8858
//#	DEPENDENT_RGB_TEXTURE_3D_NV			= 0x8859
//#	DEPENDENT_RGB_TEXTURE_CUBE_MAP_NV		= 0x885A
//#	DOT_PRODUCT_PASS_THROUGH_NV			= 0x885B
//#	DOT_PRODUCT_TEXTURE_1D_NV			= 0x885C
//#	DOT_PRODUCT_AFFINE_DEPTH_REPLACE_NV		= 0x885D
//#	HILO8_NV					= 0x885E
//#	SIGNED_HILO8_NV					= 0x885F
//#	FORCE_BLUE_TO_ONE_NV				= 0x8860
//
//# VERSION_2_0 enum: (Promoted for OpenGL 2.0)
//# ARB_point_sprite enum:
//# NV_point_sprite enum:
//#	POINT_SPRITE					= 0x8861    # VERSION_2_0
//#	POINT_SPRITE_ARB				= 0x8861
//#	POINT_SPRITE_NV					= 0x8861
//#	COORD_REPLACE					= 0x8862    # VERSION_2_0
//#	COORD_REPLACE_ARB				= 0x8862
//#	COORD_REPLACE_NV				= 0x8862
//
//# NV_point_sprite enum:
//#	POINT_SPRITE_R_MODE_NV				= 0x8863
//
//# VERSION_1_5 enum: (Promoted for OpenGL 1.5)
//# ARB_occlusion_query enum:
//# NV_occlusion_query enum:
//#	QUERY_COUNTER_BITS				= 0x8864
//#	QUERY_COUNTER_BITS_ARB				= 0x8864
//#	PIXEL_COUNTER_BITS_NV				= 0x8864
//#	CURRENT_QUERY					= 0x8865
//#	CURRENT_QUERY_ARB				= 0x8865
//#	CURRENT_OCCLUSION_QUERY_ID_NV			= 0x8865
//#	QUERY_RESULT					= 0x8866
//#	QUERY_RESULT_ARB				= 0x8866
//#	PIXEL_COUNT_NV					= 0x8866
//#	QUERY_RESULT_AVAILABLE				= 0x8867
//#	QUERY_RESULT_AVAILABLE_ARB			= 0x8867
//#	PIXEL_COUNT_AVAILABLE_NV			= 0x8867
//
//# NV_fragment_program enum:
//#	MAX_FRAGMENT_PROGRAM_LOCAL_PARAMETERS_NV	= 0x8868
//
//# VERSION_2_0 enum: (Promoted from ARB_vertex_shader)
//# ARB_vertex_program enum: (additional; see above)
//#	MAX_VERTEX_ATTRIBS				= 0x8869    # VERSION_2_0
//#	MAX_VERTEX_ATTRIBS_ARB				= 0x8869
//#	VERTEX_ATTRIB_ARRAY_NORMALIZED			= 0x886A    # VERSION_2_0
//#	VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB		= 0x886A
//
//# NV_future_use: 0x886B-0x886D
//
//# NV_copy_depth_to_color enum:
//#	DEPTH_STENCIL_TO_RGBA_NV			= 0x886E
//#	DEPTH_STENCIL_TO_BGRA_NV			= 0x886F
//
//# VERSION_2_0 enum: (Promoted from ARB_fragment_shader; only some values)
//# ARB_vertex_program enum: (additional; see above)
//# ARB_fragment_program enum: (additional; see above)
//# NV_fragment_program enum: (additional; see above)
//#	FRAGMENT_PROGRAM_NV				= 0x8870
//#	MAX_TEXTURE_COORDS				= 0x8871    # VERSION_2_0
//#	MAX_TEXTURE_COORDS_ARB				= 0x8871    # ARB_fragment_program
//#	MAX_TEXTURE_COORDS_NV				= 0x8871
//#	MAX_TEXTURE_IMAGE_UNITS				= 0x8872    # VERSION_2_0
//#	MAX_TEXTURE_IMAGE_UNITS_ARB			= 0x8872    # ARB_fragment_program
//#	MAX_TEXTURE_IMAGE_UNITS_NV			= 0x8872
//#	FRAGMENT_PROGRAM_BINDING_NV			= 0x8873
//#	PROGRAM_ERROR_STRING_ARB			= 0x8874    # ARB_vertex_program / ARB_fragment_program
//#	PROGRAM_ERROR_STRING_NV				= 0x8874
//#	PROGRAM_FORMAT_ASCII_ARB			= 0x8875    # ARB_vertex_program / ARB_fragment_program
//#	PROGRAM_FORMAT_ARB				= 0x8876    # ARB_vertex_program / ARB_fragment_program
//
//# 0x8877 *should have been* assigned to PROGRAM_BINDING_ARB. Oops.
//
//# NV_pixel_data_range enum:
//#	WRITE_PIXEL_DATA_RANGE_NV			= 0x8878
//#	READ_PIXEL_DATA_RANGE_NV			= 0x8879
//#	WRITE_PIXEL_DATA_RANGE_LENGTH_NV		= 0x887A
//#	READ_PIXEL_DATA_RANGE_LENGTH_NV			= 0x887B
//#	WRITE_PIXEL_DATA_RANGE_POINTER_NV		= 0x887C
//#	READ_PIXEL_DATA_RANGE_POINTER_NV		= 0x887D
//
//# NV_future_use: 0x887E-0x887F
//
//# NV_float_buffer enum:
//#	FLOAT_R_NV					= 0x8880
//#	FLOAT_RG_NV					= 0x8881
//#	FLOAT_RGB_NV					= 0x8882
//#	FLOAT_RGBA_NV					= 0x8883
//#	FLOAT_R16_NV					= 0x8884
//#	FLOAT_R32_NV					= 0x8885
//#	FLOAT_RG16_NV					= 0x8886
//#	FLOAT_RG32_NV					= 0x8887
//#	FLOAT_RGB16_NV					= 0x8888
//#	FLOAT_RGB32_NV					= 0x8889
//#	FLOAT_RGBA16_NV					= 0x888A
//#	FLOAT_RGBA32_NV					= 0x888B
//#	TEXTURE_FLOAT_COMPONENTS_NV			= 0x888C
//#	FLOAT_CLEAR_COLOR_VALUE_NV			= 0x888D
//#	FLOAT_RGBA_MODE_NV				= 0x888E
//
//# NV_texture_expand_normal enum:
//#	TEXTURE_UNSIGNED_REMAP_MODE_NV			= 0x888F
//
//# EXT_depth_bounds_test enum:
//#	DEPTH_BOUNDS_TEST_EXT				= 0x8890
//#	DEPTH_BOUNDS_EXT				= 0x8891
//
//# VERSION_1_5 enum: (Promoted for OpenGL 1.5)
//# ARB_vertex_buffer_object enum:
//#	ARRAY_BUFFER					= 0x8892
//#	ARRAY_BUFFER_ARB				= 0x8892
//#	ELEMENT_ARRAY_BUFFER				= 0x8893
//#	ELEMENT_ARRAY_BUFFER_ARB			= 0x8893
//#	ARRAY_BUFFER_BINDING				= 0x8894
//#	ARRAY_BUFFER_BINDING_ARB			= 0x8894
//#	ELEMENT_ARRAY_BUFFER_BINDING			= 0x8895
//#	ELEMENT_ARRAY_BUFFER_BINDING_ARB		= 0x8895
//#	VERTEX_ARRAY_BUFFER_BINDING			= 0x8896
//#	VERTEX_ARRAY_BUFFER_BINDING_ARB			= 0x8896
//#	NORMAL_ARRAY_BUFFER_BINDING			= 0x8897
//#	NORMAL_ARRAY_BUFFER_BINDING_ARB			= 0x8897
//#	COLOR_ARRAY_BUFFER_BINDING			= 0x8898
//#	COLOR_ARRAY_BUFFER_BINDING_ARB			= 0x8898
//#	INDEX_ARRAY_BUFFER_BINDING			= 0x8899
//#	INDEX_ARRAY_BUFFER_BINDING_ARB			= 0x8899
//#	TEXTURE_COORD_ARRAY_BUFFER_BINDING		= 0x889A
//#	TEXTURE_COORD_ARRAY_BUFFER_BINDING_ARB		= 0x889A
//#	EDGE_FLAG_ARRAY_BUFFER_BINDING			= 0x889B
//#	EDGE_FLAG_ARRAY_BUFFER_BINDING_ARB		= 0x889B
//#	SECONDARY_COLOR_ARRAY_BUFFER_BINDING		= 0x889C
//#	SECONDARY_COLOR_ARRAY_BUFFER_BINDING_ARB	= 0x889C
//#	FOG_COORD_ARRAY_BUFFER_BINDING			= GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING
//#	FOG_COORDINATE_ARRAY_BUFFER_BINDING		= 0x889D
//#	FOG_COORDINATE_ARRAY_BUFFER_BINDING_ARB		= 0x889D
//#	WEIGHT_ARRAY_BUFFER_BINDING			= 0x889E
//#	WEIGHT_ARRAY_BUFFER_BINDING_ARB			= 0x889E
//#	VERTEX_ATTRIB_ARRAY_BUFFER_BINDING		= 0x889F
//#	VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB		= 0x889F

@JvmInline
value class BufferTarget(val i: Int) {
    companion object {
        val ARRAY = BufferTarget(GL15.GL_ARRAY_BUFFER)
        val ATOMIC_COUNTER = BufferTarget(GL42.GL_ATOMIC_COUNTER_BUFFER)
        val COPY_READ = BufferTarget(GL31.GL_COPY_READ_BUFFER)
        val COPY_WRITE = BufferTarget(GL31.GL_COPY_WRITE_BUFFER)
        val DISPATCH_INDIRECT = BufferTarget(GL43.GL_DISPATCH_INDIRECT_BUFFER)
        val DRAW_INDIRECT = BufferTarget(GL40.GL_DRAW_INDIRECT_BUFFER)
        val ELEMENT_ARRAY = BufferTarget(GL15.GL_ELEMENT_ARRAY_BUFFER)
        val PIXEL_PACK = BufferTarget(GL21.GL_PIXEL_PACK_BUFFER)
        val PIXEL_UNPACK = BufferTarget(GL21.GL_PIXEL_UNPACK_BUFFER)
        val QUERY = BufferTarget(GL44C.GL_QUERY_BUFFER)
        val SHADER_STORAGE = BufferTarget(GL43.GL_SHADER_STORAGE_BUFFER)
        val TEXTURE = BufferTarget(GL31.GL_TEXTURE_BUFFER)
        val TRANSFORM_FEEDBACK = BufferTarget(GL30.GL_TRANSFORM_FEEDBACK_BUFFER)
        val UNIFORM = BufferTarget(GL31.GL_UNIFORM_BUFFER)
    }
}


@JvmInline
value class BufferTarget2(val i: Int) {
    companion object {
        /** Atomic counter storage */
        val ATOMIC_COUNTER = BufferTarget2(GL42.GL_ATOMIC_COUNTER_BUFFER)

        /** Read-write storage for shaders */
        val SHADER_STORAGE = BufferTarget2(GL43.GL_SHADER_STORAGE_BUFFER)

        /** Texture data buffer */
//        val TEXTURE = BufferTarget2(GL31.GL_TEXTURE_BUFFER)

        /** Transform feedback buffer */
        val TRANSFORM_FEEDBACK = BufferTarget2(GL31.GL_TRANSFORM_FEEDBACK_BUFFER)

        /** Uniform block storage */
        val UNIFORM = BufferTarget2(GL31.GL_UNIFORM_BUFFER)
    }
}

//# ARB_vertex_program enum: (additional; see above)
//# ARB_fragment_program enum: (additional; see above)
//#	PROGRAM_INSTRUCTIONS_ARB			= 0x88A0
//#	MAX_PROGRAM_INSTRUCTIONS_ARB			= 0x88A1
//#	PROGRAM_NATIVE_INSTRUCTIONS_ARB			= 0x88A2
//#	MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB		= 0x88A3
//#	PROGRAM_TEMPORARIES_ARB				= 0x88A4
//#	MAX_PROGRAM_TEMPORARIES_ARB			= 0x88A5
//#	PROGRAM_NATIVE_TEMPORARIES_ARB			= 0x88A6
//#	MAX_PROGRAM_NATIVE_TEMPORARIES_ARB		= 0x88A7
//#	PROGRAM_PARAMETERS_ARB				= 0x88A8
//#	MAX_PROGRAM_PARAMETERS_ARB			= 0x88A9
//#	PROGRAM_NATIVE_PARAMETERS_ARB			= 0x88AA
//#	MAX_PROGRAM_NATIVE_PARAMETERS_ARB		= 0x88AB
//#	PROGRAM_ATTRIBS_ARB				= 0x88AC
//#	MAX_PROGRAM_ATTRIBS_ARB				= 0x88AD
//#	PROGRAM_NATIVE_ATTRIBS_ARB			= 0x88AE
//#	MAX_PROGRAM_NATIVE_ATTRIBS_ARB			= 0x88AF
//#	PROGRAM_ADDRESS_REGISTERS_ARB			= 0x88B0
//#	MAX_PROGRAM_ADDRESS_REGISTERS_ARB		= 0x88B1
//#	PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB		= 0x88B2
//#	MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB	= 0x88B3
//#	MAX_PROGRAM_LOCAL_PARAMETERS_ARB		= 0x88B4
//#	MAX_PROGRAM_ENV_PARAMETERS_ARB			= 0x88B5
//#	PROGRAM_UNDER_NATIVE_LIMITS_ARB			= 0x88B6
//#	TRANSPOSE_CURRENT_MATRIX_ARB			= 0x88B7
//
//# VERSION_1_5 enum: (Promoted for OpenGL 1.5)
//# ARB_vertex_buffer_object enum: (additional; see above)
@JvmInline
value class BufferAccess(val i: Int) {
    companion object {
        val READ_ONLY = BufferAccess(GL15.GL_READ_ONLY)
        //#	READ_ONLY_ARB					= 0x88B8
        val WRITE_ONLY = BufferAccess(GL15.GL_WRITE_ONLY)
        //#	WRITE_ONLY_ARB					= 0x88B9
        val READ_WRITE = BufferAccess(GL15.GL_READ_WRITE)
    }
}


//#	READ_WRITE_ARB					= 0x88BA
//#	BUFFER_ACCESS					= 0x88BB
//#	BUFFER_ACCESS_ARB				= 0x88BB
//#	BUFFER_MAPPED					= 0x88BC
//#	BUFFER_MAPPED_ARB				= 0x88BC
//#	BUFFER_MAP_POINTER				= 0x88BD
//#	BUFFER_MAP_POINTER_ARB				= 0x88BD
//
//# NV_future_use: 0x88BE
//
//# EXT_timer_query enum:
//#	TIME_ELAPSED_EXT				= 0x88BF
//
//# ARB_vertex_program enum: (additional; see above)
//# ARB_fragment_program enum: (additional; see above)
//#	MATRIX0_ARB					= 0x88C0
//#	MATRIX1_ARB					= 0x88C1
//#	MATRIX2_ARB					= 0x88C2
//#	MATRIX3_ARB					= 0x88C3
//#	MATRIX4_ARB					= 0x88C4
//#	MATRIX5_ARB					= 0x88C5
//#	MATRIX6_ARB					= 0x88C6
//#	MATRIX7_ARB					= 0x88C7
//#	MATRIX8_ARB					= 0x88C8
//#	MATRIX9_ARB					= 0x88C9
//#	MATRIX10_ARB					= 0x88CA
//#	MATRIX11_ARB					= 0x88CB
//#	MATRIX12_ARB					= 0x88CC
//#	MATRIX13_ARB					= 0x88CD
//#	MATRIX14_ARB					= 0x88CE
//#	MATRIX15_ARB					= 0x88CF
//#	MATRIX16_ARB					= 0x88D0
//#	MATRIX17_ARB					= 0x88D1
//#	MATRIX18_ARB					= 0x88D2
//#	MATRIX19_ARB					= 0x88D3
//#	MATRIX20_ARB					= 0x88D4
//#	MATRIX21_ARB					= 0x88D5
//#	MATRIX22_ARB					= 0x88D6
//#	MATRIX23_ARB					= 0x88D7
//#	MATRIX24_ARB					= 0x88D8
//#	MATRIX25_ARB					= 0x88D9
//#	MATRIX26_ARB					= 0x88DA
//#	MATRIX27_ARB					= 0x88DB
//#	MATRIX28_ARB					= 0x88DC
//#	MATRIX29_ARB					= 0x88DD
//#	MATRIX30_ARB					= 0x88DE
//#	MATRIX31_ARB					= 0x88DF
//
//# VERSION_1_5 enum: (Promoted for OpenGL 1.5)
//# ARB_vertex_buffer_object enum: (additional; see above)
@JvmInline
value class Usage(val i: Int) {
    companion object {
        val STREAM_DRAW = Usage(GL15.GL_STREAM_DRAW)
        val STREAM_READ = Usage(GL15.GL_STREAM_READ)
        val STREAM_COPY = Usage(GL15.GL_STREAM_COPY)
        val STATIC_DRAW = Usage(GL15.GL_STATIC_DRAW)
        val STATIC_READ = Usage(GL15.GL_STATIC_READ)
        val STATIC_COPY = Usage(GL15.GL_STATIC_COPY)
        val DYNAMIC_DRAW = Usage(GL15.GL_DYNAMIC_DRAW)
        val DYNAMIC_READ = Usage(GL15.GL_DYNAMIC_READ)
        val DYNAMIC_COPY = Usage(GL15.GL_DYNAMIC_COPY)
    }
}

//# VERSION_2_1 enum:
//# ARB_pixel_buffer_object enum:
//# EXT_pixel_buffer_object enum:
//#	PIXEL_PACK_BUFFER				= 0x88EB    # VERSION_2_1
//#	PIXEL_PACK_BUFFER_ARB				= 0x88EB    # ARB_pixel_buffer_object
//#	PIXEL_PACK_BUFFER_EXT				= 0x88EB    # EXT_pixel_buffer_object
//#	PIXEL_UNPACK_BUFFER				= 0x88EC    # VERSION_2_1
//#	PIXEL_UNPACK_BUFFER_ARB				= 0x88EC    # ARB_pixel_buffer_object
//#	PIXEL_UNPACK_BUFFER_EXT				= 0x88EC    # EXT_pixel_buffer_object
//#	PIXEL_PACK_BUFFER_BINDING			= 0x88ED    # VERSION_2_1
//#	PIXEL_PACK_BUFFER_BINDING_ARB			= 0x88ED    # ARB_pixel_buffer_object
//#	PIXEL_PACK_BUFFER_BINDING_EXT			= 0x88ED    # EXT_pixel_buffer_object
//#	PIXEL_UNPACK_BUFFER_BINDING			= 0x88EF    # VERSION_2_1
//#	PIXEL_UNPACK_BUFFER_BINDING_ARB			= 0x88EF    # ARB_pixel_buffer_object
//#	PIXEL_UNPACK_BUFFER_BINDING_EXT			= 0x88EF    # EXT_pixel_buffer_object
//
//# ARB_future_use: 0x88E3, 0x88E7, 0x88EE
//# (for extending ARB_vertex_buffer_object):
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_packed_depth_stencil enum: (additional; see above)
//#	DEPTH24_STENCIL8				= 0x88F0    # 3.0 / ARB_fbo
//#	DEPTH24_STENCIL8_EXT				= 0x88F0
//#	TEXTURE_STENCIL_SIZE				= 0x88F1    # 3.0 / ARB_fbo
//#	TEXTURE_STENCIL_SIZE_EXT			= 0x88F1
//
//# EXT_stencil_clear_tag enum:
//#	STENCIL_TAG_BITS_EXT				= 0x88F2
//#	STENCIL_CLEAR_TAG_VALUE_EXT			= 0x88F3
//
//# NV_vertex_program2_option enum: (duplicated in NV_fragment_prgoram2 below)
//#	MAX_PROGRAM_EXEC_INSTRUCTIONS_NV		= 0x88F4
//#	MAX_PROGRAM_CALL_DEPTH_NV			= 0x88F5
//
//# NV_fragment_program2 enum:
//#	MAX_PROGRAM_EXEC_INSTRUCTIONS_NV		= 0x88F4
//#	MAX_PROGRAM_CALL_DEPTH_NV			= 0x88F5
//#	MAX_PROGRAM_IF_DEPTH_NV				= 0x88F6
//#	MAX_PROGRAM_LOOP_DEPTH_NV			= 0x88F7
//#	MAX_PROGRAM_LOOP_COUNT_NV			= 0x88F8
//
//# NV_future_use: 0x88F9-0x88FC
//
//# VERSION_3_0 enum:
//# NV_vertex_program4 enum:
//#	VERTEX_ATTRIB_ARRAY_INTEGER			= 0x88FD    # 3.0
//#	VERTEX_ATTRIB_ARRAY_INTEGER_NV			= 0x88FD
//
//# ARB_instanced_arrays enum:
//#	VERTEX_ATTRIB_ARRAY_DIVISOR_ARB			= 0x88FE
//
//# VERSION_3_0 enum:
//# EXT_texture_array enum: (additional; see below)
//#	MAX_ARRAY_TEXTURE_LAYERS			= 0x88FF    # 3.0
//#	MAX_ARRAY_TEXTURE_LAYERS_EXT			= 0x88FF
//
//# VERSION_3_0 enum:
//# NV_gpu_program4 enum:
//#	MIN_PROGRAM_TEXEL_OFFSET			= 0x8904    # 3.0
//#	MIN_PROGRAM_TEXEL_OFFSET_NV			= 0x8904
//#	MAX_PROGRAM_TEXEL_OFFSET			= 0x8905    # 3.0
//#	MAX_PROGRAM_TEXEL_OFFSET_NV			= 0x8905
//#	PROGRAM_ATTRIB_COMPONENTS_NV			= 0x8906
//#	PROGRAM_RESULT_COMPONENTS_NV			= 0x8907
//#	MAX_PROGRAM_ATTRIB_COMPONENTS_NV		= 0x8908
//#	MAX_PROGRAM_RESULT_COMPONENTS_NV		= 0x8909
//
//# EXT_stencil_two_side enum:
//#	STENCIL_TEST_TWO_SIDE_EXT			= 0x8910
//#	ACTIVE_STENCIL_FACE_EXT				= 0x8911
//
//# EXT_texture_mirror_clamp enum: (additional; see above):
//#	MIRROR_CLAMP_TO_BORDER_EXT			= 0x8912
//
//# NV_future_use: 0x8913
//
//# VERSION_1_5 enum: (Promoted for OpenGL 1.5)
//# ARB_occlusion_query enum: (additional; see above)
//#	SAMPLES_PASSED					= 0x8914
//#	SAMPLES_PASSED_ARB				= 0x8914
//
//# NV_future_use: 0x8915-0x8919
//
//# VERSION_3_0 enum:
//# ARB_color_buffer_float enum: (additional; see above)
//#	CLAMP_VERTEX_COLOR				= 0x891A    # 3.0
//#	CLAMP_VERTEX_COLOR_ARB				= 0x891A
//#	CLAMP_FRAGMENT_COLOR				= 0x891B    # 3.0
//#	CLAMP_FRAGMENT_COLOR_ARB			= 0x891B
//#	CLAMP_READ_COLOR				= 0x891C    # 3.0
//#	CLAMP_READ_COLOR_ARB				= 0x891C
//#	FIXED_ONLY					= 0x891D    # 3.0
//#	FIXED_ONLY_ARB					= 0x891D
//
//# NV_future_use: 0x891E-0x891F
//
//###############################################################################
//
//# ATI: 0x8920-0x897F
//# ATI_fragment_shader enum:
//#	FRAGMENT_SHADER_ATI				= 0x8920
//#	REG_0_ATI					= 0x8921
//#	REG_1_ATI					= 0x8922
//#	REG_2_ATI					= 0x8923
//#	REG_3_ATI					= 0x8924
//#	REG_4_ATI					= 0x8925
//#	REG_5_ATI					= 0x8926
//#	REG_6_ATI					= 0x8927
//#	REG_7_ATI					= 0x8928
//#	REG_8_ATI					= 0x8929
//#	REG_9_ATI					= 0x892A
//#	REG_10_ATI					= 0x892B
//#	REG_11_ATI					= 0x892C
//#	REG_12_ATI					= 0x892D
//#	REG_13_ATI					= 0x892E
//#	REG_14_ATI					= 0x892F
//#	REG_15_ATI					= 0x8930
//#	REG_16_ATI					= 0x8931
//#	REG_17_ATI					= 0x8932
//#	REG_18_ATI					= 0x8933
//#	REG_19_ATI					= 0x8934
//#	REG_20_ATI					= 0x8935
//#	REG_21_ATI					= 0x8936
//#	REG_22_ATI					= 0x8937
//#	REG_23_ATI					= 0x8938
//#	REG_24_ATI					= 0x8939
//#	REG_25_ATI					= 0x893A
//#	REG_26_ATI					= 0x893B
//#	REG_27_ATI					= 0x893C
//#	REG_28_ATI					= 0x893D
//#	REG_29_ATI					= 0x893E
//#	REG_30_ATI					= 0x893F
//#	REG_31_ATI					= 0x8940
//#	CON_0_ATI					= 0x8941
//#	CON_1_ATI					= 0x8942
//#	CON_2_ATI					= 0x8943
//#	CON_3_ATI					= 0x8944
//#	CON_4_ATI					= 0x8945
//#	CON_5_ATI					= 0x8946
//#	CON_6_ATI					= 0x8947
//#	CON_7_ATI					= 0x8948
//#	CON_8_ATI					= 0x8949
//#	CON_9_ATI					= 0x894A
//#	CON_10_ATI					= 0x894B
//#	CON_11_ATI					= 0x894C
//#	CON_12_ATI					= 0x894D
//#	CON_13_ATI					= 0x894E
//#	CON_14_ATI					= 0x894F
//#	CON_15_ATI					= 0x8950
//#	CON_16_ATI					= 0x8951
//#	CON_17_ATI					= 0x8952
//#	CON_18_ATI					= 0x8953
//#	CON_19_ATI					= 0x8954
//#	CON_20_ATI					= 0x8955
//#	CON_21_ATI					= 0x8956
//#	CON_22_ATI					= 0x8957
//#	CON_23_ATI					= 0x8958
//#	CON_24_ATI					= 0x8959
//#	CON_25_ATI					= 0x895A
//#	CON_26_ATI					= 0x895B
//#	CON_27_ATI					= 0x895C
//#	CON_28_ATI					= 0x895D
//#	CON_29_ATI					= 0x895E
//#	CON_30_ATI					= 0x895F
//#	CON_31_ATI					= 0x8960
//#	MOV_ATI						= 0x8961
//#	ADD_ATI						= 0x8963
//#	MUL_ATI						= 0x8964
//#	SUB_ATI						= 0x8965
//#	DOT3_ATI					= 0x8966
//#	DOT4_ATI					= 0x8967
//#	MAD_ATI						= 0x8968
//#	LERP_ATI					= 0x8969
//#	CND_ATI						= 0x896A
//#	CND0_ATI					= 0x896B
//#	DOT2_ADD_ATI					= 0x896C
//#	SECONDARY_INTERPOLATOR_ATI			= 0x896D
//#	NUM_FRAGMENT_REGISTERS_ATI			= 0x896E
//#	NUM_FRAGMENT_CONSTANTS_ATI			= 0x896F
//#	NUM_PASSES_ATI					= 0x8970
//#	NUM_INSTRUCTIONS_PER_PASS_ATI			= 0x8971
//#	NUM_INSTRUCTIONS_TOTAL_ATI			= 0x8972
//#	NUM_INPUT_INTERPOLATOR_COMPONENTS_ATI		= 0x8973
//#	NUM_LOOPBACK_COMPONENTS_ATI			= 0x8974
//#	COLOR_ALPHA_PAIRING_ATI				= 0x8975
//#	SWIZZLE_STR_ATI					= 0x8976
//#	SWIZZLE_STQ_ATI					= 0x8977
//#	SWIZZLE_STR_DR_ATI				= 0x8978
//#	SWIZZLE_STQ_DQ_ATI				= 0x8979
//#	SWIZZLE_STRQ_ATI				= 0x897A
//#	SWIZZLE_STRQ_DQ_ATI				= 0x897B
//# ??? Not clear where to put new types of mask bits yet
//#	RED_BIT_ATI					= 0x00000001
//#	GREEN_BIT_ATI					= 0x00000002
//#	BLUE_BIT_ATI					= 0x00000004
//#	2X_BIT_ATI					= 0x00000001
//#	4X_BIT_ATI					= 0x00000002
//#	8X_BIT_ATI					= 0x00000004
//#	HALF_BIT_ATI					= 0x00000008
//#	QUARTER_BIT_ATI					= 0x00000010
//#	EIGHTH_BIT_ATI					= 0x00000020
//#	SATURATE_BIT_ATI				= 0x00000040
//#	2X_BIT_ATI					= 0x00000001
//#	COMP_BIT_ATI					= 0x00000002
//#	NEGATE_BIT_ATI					= 0x00000004
//#	BIAS_BIT_ATI					= 0x00000008
//
//# ATI_future_use: 0x897C-0x897F
//
//###############################################################################
//
//# Khronos OpenML WG: 0x8980-0x898F
//
//# OML_interlace enum:
//#	INTERLACE_OML					= 0x8980
//#	INTERLACE_READ_OML				= 0x8981
//
//# OML_subsample enum:
//#	FORMAT_SUBSAMPLE_24_24_OML			= 0x8982
//#	FORMAT_SUBSAMPLE_244_244_OML			= 0x8983
//
//# OML_resample enum:
//#	PACK_RESAMPLE_OML				= 0x8984
//#	UNPACK_RESAMPLE_OML				= 0x8985
//#	RESAMPLE_REPLICATE_OML				= 0x8986
//#	RESAMPLE_ZERO_FILL_OML				= 0x8987
//#	RESAMPLE_AVERAGE_OML				= 0x8988
//#	RESAMPLE_DECIMATE_OML				= 0x8989
//
//# Assigned to Affie Munshi for OES_point_size_array/OES_matrix_get extensions
//# OES_point_size_array enum:	0x898A-
//# OES_matrix_get enum:		0x898F
//
//###############################################################################
//
//# 3dlabs: 0x8990-0x899F
//
//###############################################################################
//
//# Matrox: 0x89A0-0x89FF
//
//###############################################################################
//
//# Apple: 0x8A00-0x8A7F
//# APPLE_vertex_program_evaluators: 0x8A00-0x8A0F?
//
//# APPLE_fence enum:
//#	DRAW_PIXELS_APPLE				= 0x8A0A
//#	FENCE_APPLE					= 0x8A0B
//
//# APPLE_future_use: 0x8A0C-0x8A11
//## From Jeremy 2006/10/18 (Bugzilla bug 632) - unknown extension name
//#	ELEMENT_ARRAY_APPLE				= 0x8A0C
//#	ELEMENT_ARRAY_TYPE_APPLE			= 0x8A0D
//#	ELEMENT_ARRAY_POINTER_APPLE			= 0x8A0E
//#	COLOR_FLOAT_APPLE				= 0x8A0F
//#	MIN_PBUFFER_VIEWPORT_DIMS_APPLE			= 0x8A10
//#	ELEMENT_BUFFER_BINDING_APPLE			= 0x8A11
//
//# APPLE_flush_buffer_range enum:
//#	BUFFER_SERIALIZED_MODIFY_APPLE			= 0x8A12
//#	BUFFER_FLUSHING_UNMAP_APPLE			= 0x8A13
//
//# APPLE_future_use: 0x8A14-0x8A7F
//
//###############################################################################
//
//# Matrox: 0x8A80-0x8AEF
//
//###############################################################################
//
//# Chromium (Brian Paul): 0x8AF0-0x8B2F
//
//###############################################################################
//
//# ARB HLSL shader extensions: 0x8B30-0x8B8F
//
//# VERSION_2_0 enum: (Promoted for OpenGL 2.0; only some values; renaming in many cases)
//# ARB_shader_objects, ARB_vertex_shader, ARB_fragment_shader enum:
//# NV_vertex_program3 enum: (reuses 0x8B4C)
//##Shader types + room for expansion
//#	FRAGMENT_SHADER					= 0x8B30    # VERSION_2_0
//#	FRAGMENT_SHADER_ARB				= 0x8B30    # ARB_fragment_shader
//#	VERTEX_SHADER					= 0x8B31    # VERSION_2_0
//#	VERTEX_SHADER_ARB				= 0x8B31    # ARB_vertex_shader
//# ARB_future_use: 0x8B32-0x8B3F
//##Container types + room for expansion
//#	PROGRAM_OBJECT_ARB				= 0x8B40    # ARB_shader_objects
//# ARB_future_use: 0x8B41-0x8B47
//##Misc. shader enums
//#	SHADER_OBJECT_ARB				= 0x8B48    # ARB_shader_objects
//#	MAX_FRAGMENT_UNIFORM_COMPONENTS			= 0x8B49    # VERSION_2_0
//#	MAX_FRAGMENT_UNIFORM_COMPONENTS_ARB		= 0x8B49    # ARB_fragment_shader
//#	MAX_VERTEX_UNIFORM_COMPONENTS			= 0x8B4A    # VERSION_2_0
//#	MAX_VERTEX_UNIFORM_COMPONENTS_ARB		= 0x8B4A    # ARB_vertex_shader
//#	MAX_VARYING_FLOATS				= 0x8B4B    # VERSION_2_0
//#	MAX_VARYING_FLOATS_ARB				= 0x8B4B    # ARB_vertex_shader
//#	MAX_VERTEX_TEXTURE_IMAGE_UNITS			= 0x8B4C    # VERSION_2_0
//#	MAX_VERTEX_TEXTURE_IMAGE_UNITS_ARB		= 0x8B4C    # ARB_vertex_shader, NV_vertex_program3
//#	MAX_COMBINED_TEXTURE_IMAGE_UNITS		= 0x8B4D    # VERSION_2_0
//#	MAX_COMBINED_TEXTURE_IMAGE_UNITS_ARB		= 0x8B4D    # ARB_vertex_shader
//#	OBJECT_TYPE_ARB					= 0x8B4E    # ARB_shader_objects
//#	SHADER_TYPE					= 0x8B4F    # VERSION_2_0 (renamed)
//#	OBJECT_SUBTYPE_ARB				= 0x8B4F    # ARB_shader_objects
//##Attribute types + room for expansion.
//#	FLOAT_VEC2					= 0x8B50    # VERSION_2_0
//#	FLOAT_VEC2_ARB					= 0x8B50    # ARB_shader_objects
//#	FLOAT_VEC3					= 0x8B51    # VERSION_2_0
//#	FLOAT_VEC3_ARB					= 0x8B51    # ARB_shader_objects
//#	FLOAT_VEC4					= 0x8B52    # VERSION_2_0
//#	FLOAT_VEC4_ARB					= 0x8B52    # ARB_shader_objects
//#	INT_VEC2					= 0x8B53    # VERSION_2_0
//#	INT_VEC2_ARB					= 0x8B53    # ARB_shader_objects
//#	INT_VEC3					= 0x8B54    # VERSION_2_0
//#	INT_VEC3_ARB					= 0x8B54    # ARB_shader_objects
//#	INT_VEC4					= 0x8B55    # VERSION_2_0
//#	INT_VEC4_ARB					= 0x8B55    # ARB_shader_objects
//#	BOOL						= 0x8B56    # VERSION_2_0
//#	BOOL_ARB					= 0x8B56    # ARB_shader_objects
//#	BOOL_VEC2					= 0x8B57    # VERSION_2_0
//#	BOOL_VEC2_ARB					= 0x8B57    # ARB_shader_objects
//#	BOOL_VEC3					= 0x8B58    # VERSION_2_0
//#	BOOL_VEC3_ARB					= 0x8B58    # ARB_shader_objects
//#	BOOL_VEC4					= 0x8B59    # VERSION_2_0
//#	BOOL_VEC4_ARB					= 0x8B59    # ARB_shader_objects
//#	FLOAT_MAT2					= 0x8B5A    # VERSION_2_0
//#	FLOAT_MAT2_ARB					= 0x8B5A    # ARB_shader_objects
//#	FLOAT_MAT3					= 0x8B5B    # VERSION_2_0
//#	FLOAT_MAT3_ARB					= 0x8B5B    # ARB_shader_objects
//#	FLOAT_MAT4					= 0x8B5C    # VERSION_2_0
//#	FLOAT_MAT4_ARB					= 0x8B5C    # ARB_shader_objects
//#	SAMPLER_1D					= 0x8B5D    # VERSION_2_0
//#	SAMPLER_1D_ARB					= 0x8B5D    # ARB_shader_objects
//#	SAMPLER_2D					= 0x8B5E    # VERSION_2_0
//#	SAMPLER_2D_ARB					= 0x8B5E    # ARB_shader_objects
//#	SAMPLER_3D					= 0x8B5F    # VERSION_2_0
//#	SAMPLER_3D_ARB					= 0x8B5F    # ARB_shader_objects
//#	SAMPLER_CUBE					= 0x8B60    # VERSION_2_0
//#	SAMPLER_CUBE_ARB				= 0x8B60    # ARB_shader_objects
//#	SAMPLER_1D_SHADOW				= 0x8B61    # VERSION_2_0
//#	SAMPLER_1D_SHADOW_ARB				= 0x8B61    # ARB_shader_objects
//#	SAMPLER_2D_SHADOW				= 0x8B62    # VERSION_2_0
//#	SAMPLER_2D_SHADOW_ARB				= 0x8B62    # ARB_shader_objects
//#	SAMPLER_2D_RECT_ARB				= 0x8B63    # ARB_shader_objects
//#	SAMPLER_2D_RECT_SHADOW_ARB			= 0x8B64    # ARB_shader_objects
//#	FLOAT_MAT2x3					= 0x8B65    # VERSION_2_1
//#	FLOAT_MAT2x4					= 0x8B66    # VERSION_2_1
//#	FLOAT_MAT3x2					= 0x8B67    # VERSION_2_1
//#	FLOAT_MAT3x4					= 0x8B68    # VERSION_2_1
//#	FLOAT_MAT4x2					= 0x8B69    # VERSION_2_1
//#	FLOAT_MAT4x3					= 0x8B6A    # VERSION_2_1
//# ARB_future_use: 0x8B6B-0x8B7F (for attribute types)
//#	DELETE_STATUS					= 0x8B80    # VERSION_2_0 (renamed)
//#	OBJECT_DELETE_STATUS_ARB			= 0x8B80    # ARB_shader_objects
//#	COMPILE_STATUS					= 0x8B81    # VERSION_2_0 (renamed)
//#	OBJECT_COMPILE_STATUS_ARB			= 0x8B81    # ARB_shader_objects
//#	LINK_STATUS					= 0x8B82    # VERSION_2_0 (renamed)
//#	OBJECT_LINK_STATUS_ARB				= 0x8B82    # ARB_shader_objects
//#	VALIDATE_STATUS					= 0x8B83    # VERSION_2_0 (renamed)
//#	OBJECT_VALIDATE_STATUS_ARB			= 0x8B83    # ARB_shader_objects
//#	INFO_LOG_LENGTH					= 0x8B84    # VERSION_2_0 (renamed)
//#	OBJECT_INFO_LOG_LENGTH_ARB			= 0x8B84    # ARB_shader_objects
//#	ATTACHED_SHADERS				= 0x8B85    # VERSION_2_0 (renamed)
//#	OBJECT_ATTACHED_OBJECTS_ARB			= 0x8B85    # ARB_shader_objects
//#	ACTIVE_UNIFORMS					= 0x8B86    # VERSION_2_0 (renamed)
//#	OBJECT_ACTIVE_UNIFORMS_ARB			= 0x8B86    # ARB_shader_objects
//#	ACTIVE_UNIFORM_MAX_LENGTH			= 0x8B87    # VERSION_2_0 (renamed)
//#	OBJECT_ACTIVE_UNIFORM_MAX_LENGTH_ARB		= 0x8B87    # ARB_shader_objects
//#	SHADER_SOURCE_LENGTH				= 0x8B88    # VERSION_2_0 (renamed)
//#	OBJECT_SHADER_SOURCE_LENGTH_ARB			= 0x8B88    # ARB_shader_objects
//#	ACTIVE_ATTRIBUTES				= 0x8B89    # VERSION_2_0 (renamed)
//#	OBJECT_ACTIVE_ATTRIBUTES_ARB			= 0x8B89    # ARB_vertex_shader
//#	ACTIVE_ATTRIBUTE_MAX_LENGTH			= 0x8B8A    # VERSION_2_0 (renamed)
//#	OBJECT_ACTIVE_ATTRIBUTE_MAX_LENGTH_ARB		= 0x8B8A    # ARB_vertex_shader
//#	FRAGMENT_SHADER_DERIVATIVE_HINT			= 0x8B8B    # VERSION_2_0
//#	FRAGMENT_SHADER_DERIVATIVE_HINT_ARB		= 0x8B8B    # ARB_fragment_shader
//#	SHADING_LANGUAGE_VERSION			= 0x8B8C    # VERSION_2_0
//#	SHADING_LANGUAGE_VERSION_ARB			= 0x8B8C    # ARB_shading_language_100
//
//# VERSION_3_0 enum:
//# ARB_geometry_shader4 enum: (additional; see below; note: no ARB suffixes)
//#	MAX_VARYING_COMPONENTS				= GL_MAX_VARYING_FLOATS     # 3.0
//
//# EXT_geometry_shader4 enum: (additional; see below)
//#	MAX_VARYING_COMPONENTS_EXT			= 0x8B4B
//
//# VERSION_2_0 enum:
//#	CURRENT_PROGRAM					= 0x8B8D
//# ARB_future_use: 0x8B8E-0x8B8F
//
//###############################################################################
//
//# Khronos OpenGL ES WG: 0x8B90-0x8B9F
//
//# OES_compressed_paletted_texture enum:
//#	PALETTE4_RGB8_OES				= 0x8B90
//#	PALETTE4_RGBA8_OES				= 0x8B91
//#	PALETTE4_R5_G6_B5_OES				= 0x8B92
//#	PALETTE4_RGBA4_OES				= 0x8B93
//#	PALETTE4_RGB5_A1_OES				= 0x8B94
//#	PALETTE8_RGB8_OES				= 0x8B95
//#	PALETTE8_RGBA8_OES				= 0x8B96
//#	PALETTE8_R5_G6_B5_OES				= 0x8B97
//#	PALETTE8_RGBA4_OES				= 0x8B98
//#	PALETTE8_RGB5_A1_OES				= 0x8B99
//
//# OES_read_format enum:
//#	IMPLEMENTATION_COLOR_READ_TYPE_OES		= 0x8B9A
//#	IMPLEMENTATION_COLOR_READ_FORMAT_OES		= 0x8B9B
//
//# Extensions names TBD, for OpenGL ES 1.1
//# These need to go in enumext.spec as well
//#	POINT_SIZE_ARRAY_OES				= 0x8B9C
//#	TEXTURE_CROP_RECT_OES				= 0x8B9D
//
//# More Khronos extensions, need to go in enumext.spec
//#	MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES		= 0x8B9E
//#	WEIGHT_INDEX_ARRAY_BUFFER_BINDING_OES		= 0x8B9F
//
//###############################################################################
//
//# Seaweed: 0x8BA0-0x8BAF
//
//###############################################################################
//
//# Mesa: 0x8BB0-0x8BBF
//#   Probably one of the two 0x8BB4 enums should be 0x8BB5, but the
//#   extension spec is not complete in any event.
//# MESA_program_debug enum:
//#	FRAGMENT_PROGRAM_POSITION_MESA			= 0x8BB0
//#	FRAGMENT_PROGRAM_CALLBACK_MESA			= 0x8BB1
//#	FRAGMENT_PROGRAM_CALLBACK_FUNC_MESA		= 0x8BB2
//#	FRAGMENT_PROGRAM_CALLBACK_DATA_MESA		= 0x8BB3
//#	VERTEX_PROGRAM_CALLBACK_MESA			= 0x8BB4
//#	VERTEX_PROGRAM_POSITION_MESA			= 0x8BB4
//#	VERTEX_PROGRAM_CALLBACK_FUNC_MESA		= 0x8BB6
//#	VERTEX_PROGRAM_CALLBACK_DATA_MESA		= 0x8BB7
//
//###############################################################################
//
//# ATI: 0x8BC0-0x8BFF
//
//###############################################################################
//
//# Imagination Tech.: 0x8C00-0x8C0F
//
//###############################################################################
//
//# NVIDIA: 0x8C10-0x8C8F (Pat Brown)
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# ARB_texture_float enum: (additional; see above)
//#	TEXTURE_RED_TYPE				= 0x8C10    # 3.0 / ARB_fbo
//#	TEXTURE_RED_TYPE_ARB				= 0x8C10
//#	TEXTURE_GREEN_TYPE				= 0x8C11    # 3.0 / ARB_fbo
//#	TEXTURE_GREEN_TYPE_ARB				= 0x8C11
//#	TEXTURE_BLUE_TYPE				= 0x8C12    # 3.0 / ARB_fbo
//#	TEXTURE_BLUE_TYPE_ARB				= 0x8C12
//#	TEXTURE_ALPHA_TYPE				= 0x8C13    # 3.0 / ARB_fbo
//#	TEXTURE_ALPHA_TYPE_ARB				= 0x8C13
//#	TEXTURE_LUMINANCE_TYPE				= 0x8C14    # 3.0 / ARB_fbo
//#	TEXTURE_LUMINANCE_TYPE_ARB			= 0x8C14
//#	TEXTURE_INTENSITY_TYPE				= 0x8C15    # 3.0 / ARB_fbo
//#	TEXTURE_INTENSITY_TYPE_ARB			= 0x8C15
//#	TEXTURE_DEPTH_TYPE				= 0x8C16    # 3.0 / ARB_fbo
//#	TEXTURE_DEPTH_TYPE_ARB				= 0x8C16
//#	UNSIGNED_NORMALIZED				= 0x8C17    # 3.0 / ARB_fbo
//#	UNSIGNED_NORMALIZED_ARB				= 0x8C17
//
//# VERSION_3_0 enum:
//# EXT_texture_array enum:
//#	TEXTURE_1D_ARRAY				= 0x8C18    # 3.0
//#	TEXTURE_1D_ARRAY_EXT				= 0x8C18
//#	PROXY_TEXTURE_1D_ARRAY				= 0x8C19    # 3.0
//#	PROXY_TEXTURE_1D_ARRAY_EXT			= 0x8C19
//#	TEXTURE_2D_ARRAY				= 0x8C1A    # 3.0
//#	TEXTURE_2D_ARRAY_EXT				= 0x8C1A
//#	PROXY_TEXTURE_2D_ARRAY				= 0x8C1B    # 3.0
//#	PROXY_TEXTURE_2D_ARRAY_EXT			= 0x8C1B
//#	TEXTURE_BINDING_1D_ARRAY			= 0x8C1C    # 3.0
//#	TEXTURE_BINDING_1D_ARRAY_EXT			= 0x8C1C
//#	TEXTURE_BINDING_2D_ARRAY			= 0x8C1D    # 3.0
//#	TEXTURE_BINDING_2D_ARRAY_EXT			= 0x8C1D
//
//# NV_future_use: 0x8C1E-0x8C25
//
//# ARB_geometry_shader4 enum: (additional; see below)
//# NV_geometry_program4 enum:
//#	GEOMETRY_PROGRAM_NV				= 0x8C26
//#	MAX_PROGRAM_OUTPUT_VERTICES_NV			= 0x8C27
//#	MAX_PROGRAM_TOTAL_OUTPUT_COMPONENTS_NV		= 0x8C28
//#	MAX_GEOMETRY_TEXTURE_IMAGE_UNITS_ARB		= 0x8C29
//#	MAX_GEOMETRY_TEXTURE_IMAGE_UNITS_EXT		= 0x8C29
//
//# ARB_texture_buffer_object enum:
//# EXT_texture_buffer_object enum:
//#	TEXTURE_BUFFER_ARB				= 0x8C2A
//#	TEXTURE_BUFFER_EXT				= 0x8C2A
//#	MAX_TEXTURE_BUFFER_SIZE_ARB			= 0x8C2B
//#	MAX_TEXTURE_BUFFER_SIZE_EXT			= 0x8C2B
//#	TEXTURE_BINDING_BUFFER_ARB			= 0x8C2C
//#	TEXTURE_BINDING_BUFFER_EXT			= 0x8C2C
//#	TEXTURE_BUFFER_FORMAT_ARB			= 0x8C2E
//#	TEXTURE_BUFFER_DATA_STORE_BINDING_EXT		= 0x8C2D
//#	TEXTURE_BUFFER_FORMAT_ARB			= 0x8C2E
//#	TEXTURE_BUFFER_FORMAT_EXT			= 0x8C2E
//
//# NV_future_use: 0x8C2F-0x8C39
//
//# VERSION_3_0 enum:
//# EXT_packed_float enum:
//#	R11F_G11F_B10F					= 0x8C3A    # 3.0
//#	R11F_G11F_B10F_EXT				= 0x8C3A
//#	UNSIGNED_INT_10F_11F_11F_REV			= 0x8C3B    # 3.0
//#	UNSIGNED_INT_10F_11F_11F_REV_EXT		= 0x8C3B
//#	RGBA_SIGNED_COMPONENTS_EXT			= 0x8C3C
//
//# VERSION_3_0 enum:
//# EXT_texture_shared_exponent enum:
//#	RGB9_E5						= 0x8C3D    # 3.0
//#	RGB9_E5_EXT					= 0x8C3D
//#	UNSIGNED_INT_5_9_9_9_REV			= 0x8C3E    # 3.0
//#	UNSIGNED_INT_5_9_9_9_REV_EXT			= 0x8C3E
//#	TEXTURE_SHARED_SIZE				= 0x8C3F    # 3.0
//#	TEXTURE_SHARED_SIZE_EXT				= 0x8C3F
//
//# VERSION_2_1 enum: (Generic formats promoted for OpenGL 2.1)
//# EXT_texture_sRGB enum:
//#	SRGB						= 0x8C40    # VERSION_2_1
//#	SRGB_EXT					= 0x8C40    # EXT_texture_sRGB
//#	SRGB8						= 0x8C41    # VERSION_2_1
//#	SRGB8_EXT					= 0x8C41    # EXT_texture_sRGB
//#	SRGB_ALPHA					= 0x8C42    # VERSION_2_1
//#	SRGB_ALPHA_EXT					= 0x8C42    # EXT_texture_sRGB
//#	SRGB8_ALPHA8					= 0x8C43    # VERSION_2_1
//#	SRGB8_ALPHA8_EXT				= 0x8C43    # EXT_texture_sRGB
//#	SLUMINANCE_ALPHA				= 0x8C44    # VERSION_2_1
//#	SLUMINANCE_ALPHA_EXT				= 0x8C44    # EXT_texture_sRGB
//#	SLUMINANCE8_ALPHA8				= 0x8C45    # VERSION_2_1
//#	SLUMINANCE8_ALPHA8_EXT				= 0x8C45    # EXT_texture_sRGB
//#	SLUMINANCE					= 0x8C46    # VERSION_2_1
//#	SLUMINANCE_EXT					= 0x8C46    # EXT_texture_sRGB
//#	SLUMINANCE8					= 0x8C47    # VERSION_2_1
//#	SLUMINANCE8_EXT					= 0x8C47    # EXT_texture_sRGB
//#	COMPRESSED_SRGB					= 0x8C48    # VERSION_2_1
//#	COMPRESSED_SRGB_EXT				= 0x8C48    # EXT_texture_sRGB
//#	COMPRESSED_SRGB_ALPHA				= 0x8C49    # VERSION_2_1
//#	COMPRESSED_SRGB_ALPHA_EXT			= 0x8C49    # EXT_texture_sRGB
//#	COMPRESSED_SLUMINANCE				= 0x8C4A    # VERSION_2_1
//#	COMPRESSED_SLUMINANCE_EXT			= 0x8C4A    # EXT_texture_sRGB
//#	COMPRESSED_SLUMINANCE_ALPHA			= 0x8C4B    # VERSION_2_1
//#	COMPRESSED_SLUMINANCE_ALPHA_EXT			= 0x8C4B    # EXT_texture_sRGB
//#	COMPRESSED_SRGB_S3TC_DXT1_EXT			= 0x8C4C
//#	COMPRESSED_SRGB_ALPHA_S3TC_DXT1_EXT		= 0x8C4D
//#	COMPRESSED_SRGB_ALPHA_S3TC_DXT3_EXT		= 0x8C4E
//#	COMPRESSED_SRGB_ALPHA_S3TC_DXT5_EXT		= 0x8C4F
//
//# NV_future_use: 0x8C50-0x8C6F
//
//# EXT_texture_compression_latc enum:
//#	COMPRESSED_LUMINANCE_LATC1_EXT			= 0x8C70
//#	COMPRESSED_SIGNED_LUMINANCE_LATC1_EXT		= 0x8C71
//#	COMPRESSED_LUMINANCE_ALPHA_LATC2_EXT		= 0x8C72
//#	COMPRESSED_SIGNED_LUMINANCE_ALPHA_LATC2_EXT	= 0x8C73
//
//# NV_future_use: 0x8C74-0x8C75
//
//# VERSION_3_0 enum:
//# EXT_transform_feedback enum:
//# NV_transform_feedback enum:
//#	TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH		= 0x8C76    # 3.0
//#	TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH_EXT	= 0x8C76
//#	BACK_PRIMARY_COLOR_NV				= 0x8C77
//#	BACK_SECONDARY_COLOR_NV				= 0x8C78
//#	TEXTURE_COORD_NV				= 0x8C79
//#	CLIP_DISTANCE_NV				= 0x8C7A
//#	VERTEX_ID_NV					= 0x8C7B
//#	PRIMITIVE_ID_NV					= 0x8C7C
//#	GENERIC_ATTRIB_NV				= 0x8C7D
//#	TRANSFORM_FEEDBACK_ATTRIBS_NV			= 0x8C7E
//#	TRANSFORM_FEEDBACK_BUFFER_MODE			= 0x8C7F    # 3.0
//#	TRANSFORM_FEEDBACK_BUFFER_MODE_EXT		= 0x8C7F
//#	TRANSFORM_FEEDBACK_BUFFER_MODE_NV		= 0x8C7F
//#	MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS	= 0x8C80    # 3.0
//#	MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_EXT	= 0x8C80
//#	MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_NV	= 0x8C80
//#	ACTIVE_VARYINGS_NV				= 0x8C81
//#	ACTIVE_VARYING_MAX_LENGTH_NV			= 0x8C82
//#	TRANSFORM_FEEDBACK_VARYINGS			= 0x8C83    # 3.0
//#	TRANSFORM_FEEDBACK_VARYINGS_EXT			= 0x8C83
//#	TRANSFORM_FEEDBACK_VARYINGS_NV			= 0x8C83
//#	TRANSFORM_FEEDBACK_BUFFER_START			= 0x8C84    # 3.0
//#	TRANSFORM_FEEDBACK_BUFFER_START_EXT		= 0x8C84
//#	TRANSFORM_FEEDBACK_BUFFER_START_NV		= 0x8C84
//#	TRANSFORM_FEEDBACK_BUFFER_SIZE			= 0x8C85    # 3.0
//#	TRANSFORM_FEEDBACK_BUFFER_SIZE_EXT		= 0x8C85
//#	TRANSFORM_FEEDBACK_BUFFER_SIZE_NV		= 0x8C85
//#	TRANSFORM_FEEDBACK_RECORD_NV			= 0x8C86
//#	PRIMITIVES_GENERATED				= 0x8C87    # 3.0
//#	PRIMITIVES_GENERATED_EXT			= 0x8C87
//#	PRIMITIVES_GENERATED_NV				= 0x8C87
//#	TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN		= 0x8C88    # 3.0
//#	TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_EXT	= 0x8C88
//#	TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_NV	= 0x8C88
//#	RASTERIZER_DISCARD				= 0x8C89    # 3.0
//#	RASTERIZER_DISCARD_EXT				= 0x8C89
//#	RASTERIZER_DISCARD_NV				= 0x8C89
//#	MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS	  = 0x8C8A  # 3.0
//#	MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_EXT = 0x8C8A
//#	MAX_TRANSFORM_FEEDBACK_INTERLEAVED_ATTRIBS_NV	= 0x8C8A
//#	MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS		= 0x8C8B    # 3.0
//#	MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_EXT	= 0x8C8B
//#	MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_NV	= 0x8C8B
//#	INTERLEAVED_ATTRIBS				= 0x8C8C    # 3.0
//#	INTERLEAVED_ATTRIBS_EXT				= 0x8C8C
//#	INTERLEAVED_ATTRIBS_NV				= 0x8C8C
//#	SEPARATE_ATTRIBS				= 0x8C8D    # 3.0
//#	SEPARATE_ATTRIBS_EXT				= 0x8C8D
//#	SEPARATE_ATTRIBS_NV				= 0x8C8D
//#	TRANSFORM_FEEDBACK_BUFFER			= 0x8C8E    # 3.0
//#	TRANSFORM_FEEDBACK_BUFFER_EXT			= 0x8C8E
//#	TRANSFORM_FEEDBACK_BUFFER_NV			= 0x8C8E
//#	TRANSFORM_FEEDBACK_BUFFER_BINDING		= 0x8C8F    # 3.0
//#	TRANSFORM_FEEDBACK_BUFFER_BINDING_EXT		= 0x8C8F
//#	TRANSFORM_FEEDBACK_BUFFER_BINDING_NV		= 0x8C8F
//
//###############################################################################
//
//# ATI: 0x8C90-0x8C9F (Affie Munshi, OpenGL ES extensions)
//
//###############################################################################
//
//# OpenGL ARB: 0x8CA0-0x8CAF
//
//# VERSION_2_0 enum:
//#	POINT_SPRITE_COORD_ORIGIN			= 0x8CA0

//#	STENCIL_BACK_REF				= 0x8CA3
//#	STENCIL_BACK_VALUE_MASK				= 0x8CA4
//#	STENCIL_BACK_WRITEMASK				= 0x8CA5
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_framebuffer_object enum: (additional; see below)
//#	FRAMEBUFFER_BINDING				= 0x8CA6    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_BINDING_EXT				= 0x8CA6
//#	DRAW_FRAMEBUFFER_BINDING			= GL_FRAMEBUFFER_BINDING    # 3.0 / ARB_fbo
//#	RENDERBUFFER_BINDING				= 0x8CA7    # 3.0 / ARB_fbo
//#	RENDERBUFFER_BINDING_EXT			= 0x8CA7
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_framebuffer_blit enum:
//#	READ_FRAMEBUFFER				= 0x8CA8    # 3.0 / ARB_fbo
//#	READ_FRAMEBUFFER_EXT				= 0x8CA8
//#	DRAW_FRAMEBUFFER				= 0x8CA9    # 3.0 / ARB_fbo
//#	DRAW_FRAMEBUFFER_EXT				= 0x8CA9
//#	DRAW_FRAMEBUFFER_BINDING_EXT			= GL_FRAMEBUFFER_BINDING_EXT
//#	READ_FRAMEBUFFER_BINDING			= 0x8CAA    # 3.0 / ARB_fbo
//#	READ_FRAMEBUFFER_BINDING_EXT			= 0x8CAA
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_framebuffer_multisample enum:
//# NV_framebuffer_multisample_coverage enum: (additional; see below)
//#	RENDERBUFFER_SAMPLES				= 0x8CAB    # 3.0 / ARB_fbo
//#	RENDERBUFFER_SAMPLES_EXT			= 0x8CAB
//#	RENDERBUFFER_COVERAGE_SAMPLES_NV		= 0x8CAB
//
//# VERSION_3_0 enum:
//# ARB_depth_buffer_float enum: (note: no ARB suffixes)
//# All enums except external format are incompatible with NV_depth_buffer_float
//#	DEPTH_COMPONENT32F				= 0x8CAC
//#	DEPTH32F_STENCIL8				= 0x8CAD
//
//# ARB_future_use: 0x8CAF
//
//###############################################################################
//
//# 3Dlabs: 0x8CB0-0x8CCF (Barthold Lichtenbelt, 2004/12/1)
//
//###############################################################################
//
//# OpenGL ARB: 0x8CD0-0x8D5F (Framebuffer object specification + headroom)
//
//# VERSION_3_0 enum:
//# ARB_geometry_shader4 enum: (additional; see below; note: no ARB suffixes)
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_framebuffer_object enum: (additional; see above)
//#	FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE		= 0x8CD0    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_EXT		= 0x8CD0
//#	FRAMEBUFFER_ATTACHMENT_OBJECT_NAME		= 0x8CD1    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_EXT		= 0x8CD1
//#	FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL		= 0x8CD2    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_EXT	= 0x8CD2
//#	FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE	 = 0x8CD3   # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_EXT = 0x8CD3
//#	FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER		= 0x8CD4    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_ATTACHMENT_TEXTURE_3D_ZOFFSET_EXT	= 0x8CD4
//#	FRAMEBUFFER_COMPLETE				= 0x8CD5    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_COMPLETE_EXT			= 0x8CD5
//#	FRAMEBUFFER_INCOMPLETE_ATTACHMENT		= 0x8CD6    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT		= 0x8CD6
//#	FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT	= 0x8CD7    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT	= 0x8CD7
//## Removed 2005/09/26 in revision #117 of the extension:
//##	  FRAMEBUFFER_INCOMPLETE_DUPLICATE_ATTACHMENT_EXT = 0x8CD8
//#	FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT		= 0x8CD9
//#	FRAMEBUFFER_INCOMPLETE_FORMATS_EXT		= 0x8CDA
//#	FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER		= 0x8CDB    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT		= 0x8CDB
//#	FRAMEBUFFER_INCOMPLETE_READ_BUFFER		= 0x8CDC    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT		= 0x8CDC
//#	FRAMEBUFFER_UNSUPPORTED				= 0x8CDD    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_UNSUPPORTED_EXT			= 0x8CDD
//## Removed 2005/05/31 in revision #113 of the extension:
//## FRAMEBUFFER_STATUS_ERROR_EXT			   = 0x8CDE
//#	MAX_COLOR_ATTACHMENTS				= 0x8CDF    # 3.0 / ARB_fbo
//#	MAX_COLOR_ATTACHMENTS_EXT			= 0x8CDF
//#	COLOR_ATTACHMENT0				= 0x8CE0    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT0_EXT				= 0x8CE0
//#	COLOR_ATTACHMENT1				= 0x8CE1    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT1_EXT				= 0x8CE1
//#	COLOR_ATTACHMENT2				= 0x8CE2    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT2_EXT				= 0x8CE2
//#	COLOR_ATTACHMENT3				= 0x8CE3    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT3_EXT				= 0x8CE3
//#	COLOR_ATTACHMENT4				= 0x8CE4    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT4_EXT				= 0x8CE4
//#	COLOR_ATTACHMENT5				= 0x8CE5    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT5_EXT				= 0x8CE5
//#	COLOR_ATTACHMENT6				= 0x8CE6    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT6_EXT				= 0x8CE6
//#	COLOR_ATTACHMENT7				= 0x8CE7    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT7_EXT				= 0x8CE7
//#	COLOR_ATTACHMENT8				= 0x8CE8    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT8_EXT				= 0x8CE8
//#	COLOR_ATTACHMENT9				= 0x8CE9    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT9_EXT				= 0x8CE9
//#	COLOR_ATTACHMENT10				= 0x8CEA    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT10_EXT				= 0x8CEA
//#	COLOR_ATTACHMENT11				= 0x8CEB    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT11_EXT				= 0x8CEB
//#	COLOR_ATTACHMENT12				= 0x8CEC    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT12_EXT				= 0x8CEC
//#	COLOR_ATTACHMENT13				= 0x8CED    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT13_EXT				= 0x8CED
//#	COLOR_ATTACHMENT14				= 0x8CEE    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT14_EXT				= 0x8CEE
//#	COLOR_ATTACHMENT15				= 0x8CEF    # 3.0 / ARB_fbo
//#	COLOR_ATTACHMENT15_EXT				= 0x8CEF
//# 0x8CF0-0x8CFF reserved for color attachments 16-31, if needed
//#	DEPTH_ATTACHMENT				= 0x8D00    # 3.0 / ARB_fbo
//#	DEPTH_ATTACHMENT_EXT				= 0x8D00
//# 0x8D01-0x8D1F reserved for depth attachments 1-31, if needed
//#	STENCIL_ATTACHMENT				= 0x8D20    # 3.0 / ARB_fbo
//#	STENCIL_ATTACHMENT_EXT				= 0x8D20
//# 0x8D21-0x8D3F reserved for stencil attachments 1-31, if needed
//#	FRAMEBUFFER					= 0x8D40    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_EXT					= 0x8D40
//#	RENDERBUFFER					= 0x8D41    # 3.0 / ARB_fbo
//#	RENDERBUFFER_EXT				= 0x8D41
//#	RENDERBUFFER_WIDTH				= 0x8D42    # 3.0 / ARB_fbo
//#	RENDERBUFFER_WIDTH_EXT				= 0x8D42
//#	RENDERBUFFER_HEIGHT				= 0x8D43    # 3.0 / ARB_fbo
//#	RENDERBUFFER_HEIGHT_EXT				= 0x8D43
//#	RENDERBUFFER_INTERNAL_FORMAT			= 0x8D44    # 3.0 / ARB_fbo
//#	RENDERBUFFER_INTERNAL_FORMAT_EXT		= 0x8D44
//# 0x8D45 unused (reserved for STENCIL_INDEX_EXT, but now use core STENCIL_INDEX instead)
//#	STENCIL_INDEX1					= 0x8D46    # 3.0 / ARB_fbo
//#	STENCIL_INDEX1_EXT				= 0x8D46
//#	STENCIL_INDEX4					= 0x8D47    # 3.0 / ARB_fbo
//#	STENCIL_INDEX4_EXT				= 0x8D47
//#	STENCIL_INDEX8					= 0x8D48    # 3.0 / ARB_fbo
//#	STENCIL_INDEX8_EXT				= 0x8D48
//#	STENCIL_INDEX16					= 0x8D49    # 3.0 / ARB_fbo
//#	STENCIL_INDEX16_EXT				= 0x8D49
//# 0x8D4A-0x8D4D reserved for additional stencil formats
//# Added 2005/05/31 in revision #113 of the extension:
//#	RENDERBUFFER_RED_SIZE				= 0x8D50    # 3.0 / ARB_fbo
//#	RENDERBUFFER_RED_SIZE_EXT			= 0x8D50
//#	RENDERBUFFER_GREEN_SIZE				= 0x8D51    # 3.0 / ARB_fbo
//#	RENDERBUFFER_GREEN_SIZE_EXT			= 0x8D51
//#	RENDERBUFFER_BLUE_SIZE				= 0x8D52    # 3.0 / ARB_fbo
//#	RENDERBUFFER_BLUE_SIZE_EXT			= 0x8D52
//#	RENDERBUFFER_ALPHA_SIZE				= 0x8D53    # 3.0 / ARB_fbo
//#	RENDERBUFFER_ALPHA_SIZE_EXT			= 0x8D53
//#	RENDERBUFFER_DEPTH_SIZE				= 0x8D54    # 3.0 / ARB_fbo
//#	RENDERBUFFER_DEPTH_SIZE_EXT			= 0x8D54
//#	RENDERBUFFER_STENCIL_SIZE			= 0x8D55    # 3.0 / ARB_fbo
//#	RENDERBUFFER_STENCIL_SIZE_EXT			= 0x8D55

@JvmInline
value class Attachment(val i: Int) {
    companion object {
        val COLOR0 = Attachment(GL30C.GL_COLOR_ATTACHMENT0)
        val COLOR1 = Attachment(GL30C.GL_COLOR_ATTACHMENT1)
        val COLOR2 = Attachment(GL30C.GL_COLOR_ATTACHMENT2)
        val COLOR3 = Attachment(GL30C.GL_COLOR_ATTACHMENT3)
        val COLOR4 = Attachment(GL30C.GL_COLOR_ATTACHMENT4)
        val COLOR5 = Attachment(GL30C.GL_COLOR_ATTACHMENT5)
        val COLOR6 = Attachment(GL30C.GL_COLOR_ATTACHMENT6)
        val COLOR7 = Attachment(GL30C.GL_COLOR_ATTACHMENT7)
        val COLOR8 = Attachment(GL30C.GL_COLOR_ATTACHMENT8)
        val COLOR9 = Attachment(GL30C.GL_COLOR_ATTACHMENT9)
        val COLOR10 = Attachment(GL30C.GL_COLOR_ATTACHMENT10)
        val COLOR11 = Attachment(GL30C.GL_COLOR_ATTACHMENT11)
        val COLOR12 = Attachment(GL30C.GL_COLOR_ATTACHMENT12)
        val COLOR13 = Attachment(GL30C.GL_COLOR_ATTACHMENT13)
        val COLOR14 = Attachment(GL30C.GL_COLOR_ATTACHMENT14)
        val COLOR15 = Attachment(GL30C.GL_COLOR_ATTACHMENT15)
        val COLOR16 = Attachment(GL30C.GL_COLOR_ATTACHMENT16)
        val COLOR17 = Attachment(GL30C.GL_COLOR_ATTACHMENT17)
        val COLOR18 = Attachment(GL30C.GL_COLOR_ATTACHMENT18)
        val COLOR19 = Attachment(GL30C.GL_COLOR_ATTACHMENT19)
        val COLOR20 = Attachment(GL30C.GL_COLOR_ATTACHMENT20)
        val COLOR21 = Attachment(GL30C.GL_COLOR_ATTACHMENT21)
        val COLOR22 = Attachment(GL30C.GL_COLOR_ATTACHMENT22)
        val COLOR23 = Attachment(GL30C.GL_COLOR_ATTACHMENT23)
        val COLOR24 = Attachment(GL30C.GL_COLOR_ATTACHMENT24)
        val COLOR25 = Attachment(GL30C.GL_COLOR_ATTACHMENT25)
        val COLOR26 = Attachment(GL30C.GL_COLOR_ATTACHMENT26)
        val COLOR27 = Attachment(GL30C.GL_COLOR_ATTACHMENT27)
        val COLOR28 = Attachment(GL30C.GL_COLOR_ATTACHMENT28)
        val COLOR29 = Attachment(GL30C.GL_COLOR_ATTACHMENT29)
        val COLOR30 = Attachment(GL30C.GL_COLOR_ATTACHMENT30)
        val COLOR31 = Attachment(GL30C.GL_COLOR_ATTACHMENT31)
        val DEPTH = Attachment(GL30C.GL_DEPTH_ATTACHMENT)
        val STENCIL = Attachment(GL30C.GL_STENCIL_ATTACHMENT)
        val DEPTH_STENCIL = Attachment(GL30C.GL_DEPTH_STENCIL_ATTACHMENT)
    }
}

//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_framebuffer_multisample enum: (additional; see above)
//# Added 2006/10/10 in revision #6b of the extension.
//#	FRAMEBUFFER_INCOMPLETE_MULTISAMPLE		= 0x8D56    # 3.0 / ARB_fbo
//#	FRAMEBUFFER_INCOMPLETE_MULTISAMPLE_EXT		= 0x8D56
//#	MAX_SAMPLES					= 0x8D57    # 3.0 / ARB_fbo
//#	MAX_SAMPLES_EXT					= 0x8D57
//# 0x8D58-0x8D5F reserved for additional FBO enums
//
//# NV_geometry_program4 enum: (additional; see above)
//#	FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER_EXT	= 0x8CD4
//
//###############################################################################
//
//# Khronos OpenGL ES WG: 0x8D60-0x8D6F
//
//# Khronos_future_use: 0x8D60-0x8D6F
//
//###############################################################################
//
//# NVIDIA: 0x8D70-0x8DEF
//# Reserved per email from Pat Brown 2005/10/13
//
//# VERSION_3_0 enum:
//# EXT_texture_integer enum:
//#	RGBA32UI					= 0x8D70    # 3.0
//#	RGBA32UI_EXT					= 0x8D70
//#	RGB32UI						= 0x8D71    # 3.0
//#	RGB32UI_EXT					= 0x8D71
//#	ALPHA32UI_EXT					= 0x8D72
//#	INTENSITY32UI_EXT				= 0x8D73
//#	LUMINANCE32UI_EXT				= 0x8D74
//#	LUMINANCE_ALPHA32UI_EXT				= 0x8D75
//#	RGBA16UI					= 0x8D76    # 3.0
//#	RGBA16UI_EXT					= 0x8D76
//#	RGB16UI						= 0x8D77    # 3.0
//#	RGB16UI_EXT					= 0x8D77
//#	ALPHA16UI_EXT					= 0x8D78
//#	INTENSITY16UI_EXT				= 0x8D79
//#	LUMINANCE16UI_EXT				= 0x8D7A
//#	LUMINANCE_ALPHA16UI_EXT				= 0x8D7B
//#	RGBA8UI						= 0x8D7C    # 3.0
//#	RGBA8UI_EXT					= 0x8D7C
//#	RGB8UI						= 0x8D7D    # 3.0
//#	RGB8UI_EXT					= 0x8D7D
//#	ALPHA8UI_EXT					= 0x8D7E
//#	INTENSITY8UI_EXT				= 0x8D7F
//#	LUMINANCE8UI_EXT				= 0x8D80
//#	LUMINANCE_ALPHA8UI_EXT				= 0x8D81
//#	RGBA32I						= 0x8D82    # 3.0
//#	RGBA32I_EXT					= 0x8D82
//#	RGB32I						= 0x8D83    # 3.0
//#	RGB32I_EXT					= 0x8D83
//#	ALPHA32I_EXT					= 0x8D84
//#	INTENSITY32I_EXT				= 0x8D85
//#	LUMINANCE32I_EXT				= 0x8D86
//#	LUMINANCE_ALPHA32I_EXT				= 0x8D87
//#	RGBA16I						= 0x8D88    # 3.0
//#	RGBA16I_EXT					= 0x8D88
//#	RGB16I						= 0x8D89    # 3.0
//#	RGB16I_EXT					= 0x8D89
//#	ALPHA16I_EXT					= 0x8D8A
//#	INTENSITY16I_EXT				= 0x8D8B
//#	LUMINANCE16I_EXT				= 0x8D8C
//#	LUMINANCE_ALPHA16I_EXT				= 0x8D8D
//#	RGBA8I						= 0x8D8E    # 3.0
//#	RGBA8I_EXT					= 0x8D8E
//#	RGB8I						= 0x8D8F    # 3.0
//#	RGB8I_EXT					= 0x8D8F
//#	ALPHA8I_EXT					= 0x8D90
//#	INTENSITY8I_EXT					= 0x8D91
//#	LUMINANCE8I_EXT					= 0x8D92
//#	LUMINANCE_ALPHA8I_EXT				= 0x8D93
//#	RED_INTEGER					= 0x8D94    # 3.0
//#	RED_INTEGER_EXT					= 0x8D94
//#	GREEN_INTEGER					= 0x8D95    # 3.0
//#	GREEN_INTEGER_EXT				= 0x8D95
//#	BLUE_INTEGER					= 0x8D96    # 3.0
//#	BLUE_INTEGER_EXT				= 0x8D96
//#	ALPHA_INTEGER					= 0x8D97    # 3.0
//#	ALPHA_INTEGER_EXT				= 0x8D97
//#	RGB_INTEGER					= 0x8D98    # 3.0
//#	RGB_INTEGER_EXT					= 0x8D98
//#	RGBA_INTEGER					= 0x8D99    # 3.0
//#	RGBA_INTEGER_EXT				= 0x8D99
//#	BGR_INTEGER					= 0x8D9A    # 3.0
//#	BGR_INTEGER_EXT					= 0x8D9A
//#	BGRA_INTEGER					= 0x8D9B    # 3.0
//#	BGRA_INTEGER_EXT				= 0x8D9B
//#	LUMINANCE_INTEGER_EXT				= 0x8D9C
//#	LUMINANCE_ALPHA_INTEGER_EXT			= 0x8D9D
//#	RGBA_INTEGER_MODE_EXT				= 0x8D9E
//
//# NV_future_use: 0x8D9F
//
//# NV_parameter_buffer_object enum:
//#	MAX_PROGRAM_PARAMETER_BUFFER_BINDINGS_NV	= 0x8DA0
//#	MAX_PROGRAM_PARAMETER_BUFFER_SIZE_NV		= 0x8DA1
//#	VERTEX_PROGRAM_PARAMETER_BUFFER_NV		= 0x8DA2
//#	GEOMETRY_PROGRAM_PARAMETER_BUFFER_NV		= 0x8DA3
//#	FRAGMENT_PROGRAM_PARAMETER_BUFFER_NV		= 0x8DA4
//
//# NV_gpu_program4 enum: (additional; see above)
//#	MAX_PROGRAM_GENERIC_ATTRIBS_NV			= 0x8DA5
//#	MAX_PROGRAM_GENERIC_RESULTS_NV			= 0x8DA6
//
//# ARB_geometry_shader4 enum: (additional; see below)
//# NV_geometry_program4 enum: (additional; see above)
//#	FRAMEBUFFER_ATTACHMENT_LAYERED_ARB		= 0x8DA7
//#	FRAMEBUFFER_ATTACHMENT_LAYERED_EXT		= 0x8DA7
//#	FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS_ARB	= 0x8DA8
//#	FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS_EXT	= 0x8DA8
//#	FRAMEBUFFER_INCOMPLETE_LAYER_COUNT_ARB		= 0x8DA9
//#	FRAMEBUFFER_INCOMPLETE_LAYER_COUNT_EXT		= 0x8DA9
//
//# NV_future_use: 0x8DAA
//# NV_future_use: 0x8DAE
//
//# VERSION_3_0 enum:
//# ARB_depth_buffer_float enum: (additional; see above; some values different from NV; note: no ARB suffixes)
//# NV_depth_buffer_float enum:
//#	DEPTH_COMPONENT32F_NV				= 0x8DAB
//#	DEPTH32F_STENCIL8_NV				= 0x8DAC
//#	FLOAT_32_UNSIGNED_INT_24_8_REV_NV		= 0x8DAD
//#	FLOAT_32_UNSIGNED_INT_24_8_REV			= 0x8DAD
//#	DEPTH_BUFFER_FLOAT_MODE_NV			= 0x8DAF
//
//# NV_future_use: 0x8DB0-0x8DB8
//
//# VERSION_3_0 enum:
//# ARB_framebuffer_sRGB enum: (note: no ARB suffixes)
//# EXT_framebuffer_sRGB enum:
//#	FRAMEBUFFER_SRGB				= 0x8DB9    # 3.0 / ARB_sRGB
//#	FRAMEBUFFER_SRGB_EXT				= 0x8DB9
//#	FRAMEBUFFER_SRGB_CAPABLE_EXT			= 0x8DBA
//
//# VERSION_3_0 enum:
//# ARB_texture_compression_rgtc enum: (note: no ARB suffixes)
//# EXT_texture_compression_rgtc enum:
//#	COMPRESSED_RED_RGTC1				= 0x8DBB    # 3.0 / ARB_tcrgtc
//#	COMPRESSED_RED_RGTC1_EXT			= 0x8DBB
//#	COMPRESSED_SIGNED_RED_RGTC1			= 0x8DBC    # 3.0 / ARB_tcrgtc
//#	COMPRESSED_SIGNED_RED_RGTC1_EXT			= 0x8DBC
//#	COMPRESSED_RG_RGTC2				= 0x8DBD    # 3.0 / ARB_tcrgtc
//#	COMPRESSED_RED_GREEN_RGTC2_EXT			= 0x8DBD
//#	COMPRESSED_SIGNED_RG_RGTC2			= 0x8DBE    # 3.0 / ARB_tcrgtc
//#	COMPRESSED_SIGNED_RED_GREEN_RGTC2_EXT		= 0x8DBE
//
//# NV_future_use: 0x8DBF
//
//# VERSION_3_0 enum:
//# EXT_gpu_shader4 enum:
//#	SAMPLER_1D_ARRAY				= 0x8DC0    # 3.0
//#	SAMPLER_1D_ARRAY_EXT				= 0x8DC0
//#	SAMPLER_2D_ARRAY				= 0x8DC1    # 3.0
//#	SAMPLER_2D_ARRAY_EXT				= 0x8DC1
//#	SAMPLER_BUFFER_EXT				= 0x8DC2
//#	SAMPLER_1D_ARRAY_SHADOW				= 0x8DC3    # 3.0
//#	SAMPLER_1D_ARRAY_SHADOW_EXT			= 0x8DC3
//#	SAMPLER_2D_ARRAY_SHADOW				= 0x8DC4    # 3.0
//#	SAMPLER_2D_ARRAY_SHADOW_EXT			= 0x8DC4
//#	SAMPLER_CUBE_SHADOW				= 0x8DC5    # 3.0
//#	SAMPLER_CUBE_SHADOW_EXT				= 0x8DC5
//#	UNSIGNED_INT_VEC2				= 0x8DC6    # 3.0
//#	UNSIGNED_INT_VEC2_EXT				= 0x8DC6
//#	UNSIGNED_INT_VEC3				= 0x8DC7    # 3.0
//#	UNSIGNED_INT_VEC3_EXT				= 0x8DC7
//#	UNSIGNED_INT_VEC4				= 0x8DC8    # 3.0
//#	UNSIGNED_INT_VEC4_EXT				= 0x8DC8
//#	INT_SAMPLER_1D					= 0x8DC9    # 3.0
//#	INT_SAMPLER_1D_EXT				= 0x8DC9
//#	INT_SAMPLER_2D					= 0x8DCA    # 3.0
//#	INT_SAMPLER_2D_EXT				= 0x8DCA
//#	INT_SAMPLER_3D					= 0x8DCB    # 3.0
//#	INT_SAMPLER_3D_EXT				= 0x8DCB
//#	INT_SAMPLER_CUBE				= 0x8DCC    # 3.0
//#	INT_SAMPLER_CUBE_EXT				= 0x8DCC
//#	INT_SAMPLER_2D_RECT_EXT				= 0x8DCD
//#	INT_SAMPLER_1D_ARRAY				= 0x8DCE    # 3.0
//#	INT_SAMPLER_1D_ARRAY_EXT			= 0x8DCE
//#	INT_SAMPLER_2D_ARRAY				= 0x8DCF    # 3.0
//#	INT_SAMPLER_2D_ARRAY_EXT			= 0x8DCF
//#	INT_SAMPLER_BUFFER_EXT				= 0x8DD0
//#	UNSIGNED_INT_SAMPLER_1D				= 0x8DD1    # 3.0
//#	UNSIGNED_INT_SAMPLER_1D_EXT			= 0x8DD1
//#	UNSIGNED_INT_SAMPLER_2D				= 0x8DD2    # 3.0
//#	UNSIGNED_INT_SAMPLER_2D_EXT			= 0x8DD2
//#	UNSIGNED_INT_SAMPLER_3D				= 0x8DD3    # 3.0
//#	UNSIGNED_INT_SAMPLER_3D_EXT			= 0x8DD3
//#	UNSIGNED_INT_SAMPLER_CUBE			= 0x8DD4    # 3.0
//#	UNSIGNED_INT_SAMPLER_CUBE_EXT			= 0x8DD4
//#	UNSIGNED_INT_SAMPLER_2D_RECT_EXT		= 0x8DD5
//#	UNSIGNED_INT_SAMPLER_1D_ARRAY			= 0x8DD6    # 3.0
//#	UNSIGNED_INT_SAMPLER_1D_ARRAY_EXT		= 0x8DD6
//#	UNSIGNED_INT_SAMPLER_2D_ARRAY			= 0x8DD7    # 3.0
//#	UNSIGNED_INT_SAMPLER_2D_ARRAY_EXT		= 0x8DD7
//#	UNSIGNED_INT_SAMPLER_BUFFER_EXT			= 0x8DD8
//
//# ARB_geometry_shader4 enum:
//# EXT_geometry_shader4 enum:
//#	GEOMETRY_SHADER_ARB				= 0x8DD9
//#	GEOMETRY_SHADER_EXT				= 0x8DD9
//
//# ARB_geometry_shader4 enum: (additional; see above)
//# NV_geometry_program4 enum: (additional; see above)
//#	GEOMETRY_VERTICES_OUT_ARB			= 0x8DDA
//#	GEOMETRY_VERTICES_OUT_EXT			= 0x8DDA
//#	GEOMETRY_INPUT_TYPE_ARB				= 0x8DDB
//#	GEOMETRY_INPUT_TYPE_EXT				= 0x8DDB
//#	GEOMETRY_OUTPUT_TYPE_ARB			= 0x8DDC
//#	GEOMETRY_OUTPUT_TYPE_EXT			= 0x8DDC
//
//# ARB_geometry_shader4 enum: (additional; see above)
//# EXT_geometry_shader4 enum: (additional; see above)
//#	MAX_GEOMETRY_VARYING_COMPONENTS_ARB		= 0x8DDD
//#	MAX_GEOMETRY_VARYING_COMPONENTS_EXT		= 0x8DDD
//#	MAX_VERTEX_VARYING_COMPONENTS_ARB		= 0x8DDE
//#	MAX_VERTEX_VARYING_COMPONENTS_EXT		= 0x8DDE
//#	MAX_GEOMETRY_UNIFORM_COMPONENTS_ARB		= 0x8DDF
//#	MAX_GEOMETRY_UNIFORM_COMPONENTS_EXT		= 0x8DDF
//#	MAX_GEOMETRY_OUTPUT_VERTICES_ARB		= 0x8DE0
//#	MAX_GEOMETRY_OUTPUT_VERTICES_EXT		= 0x8DE0
//#	MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS_ARB	= 0x8DE1
//#	MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS_EXT	= 0x8DE1
//
//# EXT_bindable_uniform enum:
//#	MAX_VERTEX_BINDABLE_UNIFORMS_EXT		= 0x8DE2
//#	MAX_FRAGMENT_BINDABLE_UNIFORMS_EXT		= 0x8DE3
//#	MAX_GEOMETRY_BINDABLE_UNIFORMS_EXT		= 0x8DE4
//
//# NV_future_use: 0x8DE5-0x8DEC
//
//# EXT_bindable_uniform enum: (additional; see above)
//#	MAX_BINDABLE_UNIFORM_SIZE_EXT			= 0x8DED
//#	UNIFORM_BUFFER_EXT				= 0x8DEE
//#	UNIFORM_BUFFER_BINDING_EXT			= 0x8DEF
//
//###############################################################################
//
//# Khronos OpenGL ES WG: 0x8DF0-0x8E0F
//
//# Khronos_future_use: 0x8DF0-0x8E0F
//
//###############################################################################
//
//# NVIDIA: 0x8E10-0x8E8F
//# Reserved per email from Michael Gold 2006/8/7
//
//# NV_framebuffer_multisample_coverage enum:
//#	RENDERBUFFER_COLOR_SAMPLES_NV			= 0x8E10
//#	MAX_MULTISAMPLE_COVERAGE_MODES_NV		= 0x8E11
//#	MULTISAMPLE_COVERAGE_MODES_NV			= 0x8E12
//
//# VERSION_3_0 enum:
//# GL_NV_conditional_render enum:
//#	QUERY_WAIT					= 0x8E13   # 3.0
//#	QUERY_WAIT_NV					= 0x8E13
//#	QUERY_NO_WAIT					= 0x8E14   # 3.0
//#	QUERY_NO_WAIT_NV				= 0x8E14
//#	QUERY_BY_REGION_WAIT				= 0x8E15   # 3.0
//#	QUERY_BY_REGION_WAIT_NV				= 0x8E15
//#	QUERY_BY_REGION_NO_WAIT				= 0x8E16   # 3.0
//#	QUERY_BY_REGION_NO_WAIT_NV			= 0x8E16
//
//# NV_future_use: 0x8E17-0x8E21
//
//# NV_transform_feedback2 enum:
//#     TRANSFORM_FEEDBACK_NV				= 0x8E22
//#     TRANSFORM_FEEDBACK_BUFFER_PAUSED_NV		= 0x8E23
//#     TRANSFORM_FEEDBACK_BUFFER_ACTIVE_NV		= 0x8E24
//#     TRANSFORM_FEEDBACK_BINDING_NV			= 0x8E25
//
//# NV_present_video enum:
//#	FRAME_NV					= 0x8E26
//#	FIELDS_NV					= 0x8E27
//#	CURRENT_TIME_NV					= 0x8E28
//#	NUM_FILL_STREAMS_NV				= 0x8E29
//#	PRESENT_TIME_NV					= 0x8E2A
//#	PRESENT_DURATION_NV				= 0x8E2B
//
//# NV_future_use: 0x8E2C
//
//# EXT_direct_state_access enum:
//#	PROGRAM_MATRIX_EXT				= 0x8E2D
//#	TRANSPOSE_PROGRAM_MATRIX_EXT			= 0x8E2E
//#	PROGRAM_MATRIX_STACK_DEPTH_EXT			= 0x8E2F
//
//# NV_future_use: 0x8E30-0x8E41

@JvmInline
value class TextureSwizzle(val i: Int) {
    companion object {
        val SWIZZLE_R = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_R)
        val SWIZZLE_G = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_G)
        val SWIZZLE_B = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_B)
        val SWIZZLE_A = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_A)
        val SWIZZLE_RGBA = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_RGBA)
    }
}

//# NV_future_use: 0x8E47-0x8E4F
//
//# NV_explicit_multisample enum:
//#	SAMPLE_POSITION_NV				= 0x8E50
//#	SAMPLE_MASK_NV					= 0x8E51
//#	SAMPLE_MASK_VALUE_NV				= 0x8E52
//#	TEXTURE_BINDING_RENDERBUFFER_NV			= 0x8E53
//#	TEXTURE_RENDERBUFFER_DATA_STORE_BINDING_NV	= 0x8E54
//#	MAX_SAMPLE_MASK_WORDS_NV			= 0x8E59
//#	TEXTURE_RENDERBUFFER_NV				= 0x8E55
//#	SAMPLER_RENDERBUFFER_NV				= 0x8E56
//#	INT_SAMPLER_RENDERBUFFER_NV			= 0x8E57
//#	UNSIGNED_INT_SAMPLER_RENDERBUFFER_NV		= 0x8E58
//
//# NV_future_use: 0x8E59-0x8E8F
//
//###############################################################################
//
//# QNX: 0x8E90-0x8E9F
//# https://cvs.khronos.org/bugzilla/show_bug.cgi?id=696
//# For GL_QNX_texture_tiling, GL_QNX_complex_polygon, GL_QNX_stippled_lines
//
//# QNX_future_use: 0x8E90-0x8E9F
//
//###############################################################################
//
//# Imagination Tech.: 0x8EA0-0x8EAF
//
//###############################################################################
//
//# Khronos OpenGL ES WG: 0x8EB0-0x8EBF
//# Assigned for Affie Munshi on 2007/07/20
//
//###############################################################################
//
//# Vincent: 0x8EC0-0x8ECF
//
//###############################################################################
//
//# NVIDIA: 0x8ED0-0x8F4F
//# Assigned for Pat Brown (Khronos bug 3191)
//
//###############################################################################
//
//# 3Dlabs: 0x8F50-0x8F5F
//# Assigned for Jon Kennedy (Khronos public bug 75)
//
//###############################################################################
//
//# ARM: 0x8F60-0x8F6F
//# Assigned for Remi Pedersen (Khronos bug 3745)
//
//###############################################################################
//
//# HI Corp: 0x8F70-0x8F7F
//# Assigned for Mark Callow (Khronos bug 4055)
//
//###############################################################################
//
//# Zebra Imaging: 0x8F80-0x8F8F
//# Assigned for Mike Weiblen (Khronos public bug 91)
//
//###############################################################################
//### Please remember that new enumerant allocations must be obtained by request
//### to the Khronos API registrar (see comments at the top of this file)
//### File requests in the Khronos Bugzilla, OpenGL project, Registry component.
//###############################################################################
//
//# Any_vendor_future_use: 0x8F90-0xFFFF
//#
//#   This range must be the last range in the file.  To generate a new
//#   range, allocate multiples of 16 from the beginning of the
//#   Any_vendor_future_use range and update enum.spec
//
//###############################################################################
//
//# ARB:	  100000-100999 (GLU enumerants only)
//# ARB:	  101000-101999 (Conformance tests only)
//
//###############################################################################
//
//# IBM:	  103000-103999
//#	CULL_VERTEX_IBM					= 103050
//#	VERTEX_ARRAY_LIST_IBM				= 103070
//#	NORMAL_ARRAY_LIST_IBM				= 103071
//#	COLOR_ARRAY_LIST_IBM				= 103072
//#	INDEX_ARRAY_LIST_IBM				= 103073
//#	TEXTURE_COORD_ARRAY_LIST_IBM			= 103074
//#	EDGE_FLAG_ARRAY_LIST_IBM			= 103075
//#	FOG_COORDINATE_ARRAY_LIST_IBM			= 103076
//#	SECONDARY_COLOR_ARRAY_LIST_IBM			= 103077
//#	VERTEX_ARRAY_LIST_STRIDE_IBM			= 103080
//#	NORMAL_ARRAY_LIST_STRIDE_IBM			= 103081
//#	COLOR_ARRAY_LIST_STRIDE_IBM			= 103082
//#	INDEX_ARRAY_LIST_STRIDE_IBM			= 103083
//#	TEXTURE_COORD_ARRAY_LIST_STRIDE_IBM		= 103084
//#	EDGE_FLAG_ARRAY_LIST_STRIDE_IBM			= 103085
//#	FOG_COORDINATE_ARRAY_LIST_STRIDE_IBM		= 103086
//#	SECONDARY_COLOR_ARRAY_LIST_STRIDE_IBM		= 103087
//
//###############################################################################
//
//# NEC:	  104000-104999
//# Compaq: 105000-105999 (Compaq was acquired by HP)
//# KPC:	  106000-106999 (Kubota is out of business)
//# PGI:	  107000-107999 (Portable was acquired by Template Graphics)
//# E&S:	  108000-108999
//
//###############################################################################

@JvmInline
value class ProvokeMode(val i: Int) {
    companion object {
        val FIRST_VERTEX_CONVENTION = ProvokeMode(GL32.GL_FIRST_VERTEX_CONVENTION)
        val LAST_VERTEX_CONVENTION = ProvokeMode(GL32.GL_LAST_VERTEX_CONVENTION)
    }
}

//###############################################################################

@JvmInline
value class DepthStencilTextureMode(val i: Int) {
    companion object {
        val DEPTH_COMPONENT = DepthStencilTextureMode(GL32.GL_DEPTH_COMPONENT)
        val STENCIL_COMPONENT = DepthStencilTextureMode(GL43.GL_STENCIL_COMPONENTS)
    }
}

//###############################################################################

@JvmInline
value class TextureCompareMode(val i: Int) {
    companion object {
        val COMPARE_REF_TO_TEXTURE = TextureCompareMode(GL30C.GL_COMPARE_REF_TO_TEXTURE)
        val NONE = TextureCompareMode(GL11.GL_NONE)
    }
}

//###############################################################################

@JvmInline
value class ImageFormatCompatibilityType(val i: Int) {
    companion object {
        val BY_SIZE = ImageFormatCompatibilityType(GL42.GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE)
        val BY_CLASS = ImageFormatCompatibilityType(GL42.GL_IMAGE_FORMAT_COMPATIBILITY_BY_CLASS)
        val NONE = ImageFormatCompatibilityType(GL11.GL_NONE)
    }
}

//###############################################################################

@JvmInline
value class BufferParameter(val i: Int) {
    companion object {
        val ACCESS = BufferParameter(GL15.GL_BUFFER_ACCESS)
        val ACCESS_FLAGS = BufferParameter(GL30.GL_BUFFER_ACCESS_FLAGS)
        val IMMUTABLE_STORAGE = BufferParameter(GL44.GL_BUFFER_IMMUTABLE_STORAGE)
        val MAPPED = BufferParameter(GL15.GL_BUFFER_MAPPED)
        val MAP_LENGTH = BufferParameter(GL30.GL_BUFFER_MAP_LENGTH)
        val MAP_OFFSET = BufferParameter(GL30.GL_BUFFER_MAP_OFFSET)
        val SIZE = BufferParameter(GL15C.GL_BUFFER_SIZE)
        val STORAGE_FLAGS = BufferParameter(GL44.GL_BUFFER_STORAGE_FLAGS)
        val USAGE = BufferParameter(GL15.GL_BUFFER_USAGE)
    }
}

//###############################################################################

@JvmInline
value class QueryTarget(val i: Int) {
    companion object {
        val SAMPLES_PASSED = QueryTarget(GL15.GL_SAMPLES_PASSED)
        val ANY_SAMPLES_PASSED = QueryTarget(GL33.GL_ANY_SAMPLES_PASSED)
        val ANY_SAMPLES_PASSED_CONSERVATIVE = QueryTarget(GL43.GL_ANY_SAMPLES_PASSED_CONSERVATIVE)
        val PRIMITIVES_GENERATED = QueryTarget(GL30.GL_PRIMITIVES_GENERATED)
        val TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = QueryTarget(GL30.GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN)
        val TIME_ELAPSED = QueryTarget(GL33.GL_TIME_ELAPSED)
        val TIMESTAMP = QueryTarget(GL33.GL_TIMESTAMP)
    }
}

@JvmInline
value class QueryIndexedTarget(val i: Int) {
    companion object {
        val SAMPLES_PASSED = QueryTarget(GL15.GL_SAMPLES_PASSED)
        val ANY_SAMPLES_PASSED = QueryTarget(GL33.GL_ANY_SAMPLES_PASSED)
        val PRIMITIVES_GENERATED = QueryTarget(GL30.GL_PRIMITIVES_GENERATED)
        val TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = QueryTarget(GL30.GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN)
        val TIME_ELAPSED = QueryTarget(GL33.GL_TIME_ELAPSED)
    }
}

//###############################################################################

@JvmInline
value class GetQuery(val i: Int) {
    companion object {
        val CURRENT_QUERY = GetQuery(GL15.GL_CURRENT_QUERY)
        val COUNTER_BITS = GetQuery(GL15.GL_QUERY_COUNTER_BITS)
    }
}

//###############################################################################

@JvmInline
value class GetQueryObject(val i: Int) {
    companion object {
        val RESULT = GetQueryObject(GL15.GL_QUERY_RESULT)
        val RESULT_NO_WAIT = GetQueryObject(GL44.GL_QUERY_RESULT_NO_WAIT)
        val RESULT_AVAILABLE = GetQueryObject(GL15.GL_QUERY_RESULT_AVAILABLE)
    }
}

//###############################################################################

@JvmInline
value class ShaderType(val i: Int) {
    companion object {
        val COMPUTE_SHADER = ShaderType(GL43.GL_COMPUTE_SHADER)
        val VERTEX_SHADER = ShaderType(GL20.GL_VERTEX_SHADER)
        val TESS_CONTROL_SHADER = ShaderType(GL40.GL_TESS_CONTROL_SHADER)
        val TESS_EVALUATION_SHADER = ShaderType(GL40.GL_TESS_EVALUATION_SHADER)
        val GEOMETRY_SHADER = ShaderType(GL32.GL_GEOMETRY_SHADER)
        val FRAGMENT_SHADER = ShaderType(GL20.GL_FRAGMENT_SHADER)
    }
}

//###############################################################################

@JvmInline
value class GetShader(val i: Int) {
    companion object {
        val SHADER_TYPE = GetShader(GL20.GL_SHADER_TYPE)
        val DELETE_STATUS = GetShader(GL20.GL_DELETE_STATUS)
        val COMPILE_STATUS = GetShader(GL20.GL_COMPILE_STATUS)
        val INFO_LOG_LENGTH = GetShader(GL20.GL_INFO_LOG_LENGTH)
        val SHADER_SOURCE_LENGTH = GetShader(GL20.GL_SHADER_SOURCE_LENGTH)
    }
}

//###############################################################################

@JvmInline
value class GetProgram(val i: Int) {
    companion object {
        val DELETE_STATUS = GetProgram(GL20.GL_DELETE_STATUS)
        val LINK_STATUS = GetProgram(GL20.GL_LINK_STATUS)
        val VALIDATE_STATUS = GetProgram(GL20.GL_VALIDATE_STATUS)
        val INFO_LOG_LENGTH = GetProgram(GL20.GL_INFO_LOG_LENGTH)
        val ATTACHED_SHADERS = GetProgram(GL20.GL_ATTACHED_SHADERS)
        val ACTIVE_ATOMIC_COUNTER_BUFFERS = GetProgram(GL42.GL_ACTIVE_ATOMIC_COUNTER_BUFFERS)
        val ACTIVE_ATTRIBUTES = GetProgram(GL20.GL_ACTIVE_ATTRIBUTES)
        val ACTIVE_ATTRIBUTE_MAX_LENGTH = GetProgram(GL20.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH)
        val ACTIVE_UNIFORMS = GetProgram(GL20.GL_ACTIVE_UNIFORMS)
        val ACTIVE_UNIFORM_BLOCKS = GetProgram(GL31.GL_ACTIVE_UNIFORM_BLOCKS)
        val ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = GetProgram(GL31.GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH)
        val ACTIVE_UNIFORM_MAX_LENGTH = GetProgram(GL20.GL_ACTIVE_UNIFORM_MAX_LENGTH)
        val COMPUTE_WORK_GROUP_SIZE = GetProgram(GL43.GL_COMPUTE_WORK_GROUP_SIZE) // Vec3i
        val PROGRAM_BINARY_LENGTH = GetProgram(GL41.GL_PROGRAM_BINARY_LENGTH)
        val TRANSFORM_FEEDBACK_BUFFER_MODE = GetProgram(GL30.GL_TRANSFORM_FEEDBACK_BUFFER_MODE)
        val TRANSFORM_FEEDBACK_VARYINGS = GetProgram(GL30.GL_TRANSFORM_FEEDBACK_VARYINGS)
        val TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = GetProgram(GL30.GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH)
        val GEOMETRY_VERTICES_OUT = GetProgram(GL32.GL_GEOMETRY_VERTICES_OUT)
        val GEOMETRY_INPUT_TYPE = GetProgram(GL32.GL_GEOMETRY_INPUT_TYPE)
        val GEOMETRY_OUTPUT_TYPE = GetProgram(GL32.GL_GEOMETRY_OUTPUT_TYPE)
        val PROGRAM_BINARY_RETRIEVABLE_HINT = GetProgram(GL41C.GL_PROGRAM_BINARY_RETRIEVABLE_HINT)
        val PROGRAM_SEPARABLE = GetProgram(GL41C.GL_PROGRAM_SEPARABLE) // TODO check if valid to get
    }
}

//###############################################################################

@JvmInline
value class UniformType(val i: Int) {
    companion object {
        val FLOAT = UniformType(GL11.GL_FLOAT)
        val FLOAT_VEC2 = UniformType(GL20.GL_FLOAT_VEC2)
        val FLOAT_VEC3 = UniformType(GL20.GL_FLOAT_VEC3)
        val FLOAT_VEC4 = UniformType(GL20.GL_FLOAT_VEC4)
        val DOUBLE = UniformType(GL11.GL_DOUBLE)
        val DOUBLE_VEC2 = UniformType(GL40.GL_DOUBLE_VEC2)
        val DOUBLE_VEC3 = UniformType(GL40.GL_DOUBLE_VEC3)
        val DOUBLE_VEC4 = UniformType(GL40.GL_DOUBLE_VEC4)
        val INT = UniformType(GL11.GL_INT)
        val INT_VEC2 = UniformType(GL20.GL_INT_VEC2)
        val INT_VEC3 = UniformType(GL20.GL_INT_VEC3)
        val INT_VEC4 = UniformType(GL20.GL_INT_VEC4)
        val UNSIGNED_INT = UniformType(GL11.GL_UNSIGNED_INT)
        val UNSIGNED_INT_VEC2 = UniformType(GL30.GL_UNSIGNED_INT_VEC2)
        val UNSIGNED_INT_VEC3 = UniformType(GL30.GL_UNSIGNED_INT_VEC3)
        val UNSIGNED_INT_VEC4 = UniformType(GL30.GL_UNSIGNED_INT_VEC4)
        val BOOL = UniformType(GL20.GL_BOOL)
        val BOOL_VEC2 = UniformType(GL20.GL_BOOL_VEC2)
        val BOOL_VEC3 = UniformType(GL20.GL_BOOL_VEC3)
        val BOOL_VEC4 = UniformType(GL20.GL_BOOL_VEC4)
        val FLOAT_MAT2 = UniformType(GL20.GL_FLOAT_MAT2)
        val FLOAT_MAT3 = UniformType(GL20.GL_FLOAT_MAT3)
        val FLOAT_MAT4 = UniformType(GL20.GL_FLOAT_MAT4)
        val FLOAT_MAT2x3 = UniformType(GL21.GL_FLOAT_MAT2x3)
        val FLOAT_MAT2x4 = UniformType(GL21.GL_FLOAT_MAT2x4)
        val FLOAT_MAT3x2 = UniformType(GL21.GL_FLOAT_MAT3x2)
        val FLOAT_MAT3x4 = UniformType(GL21.GL_FLOAT_MAT3x4)
        val FLOAT_MAT4x2 = UniformType(GL21.GL_FLOAT_MAT4x2)
        val FLOAT_MAT4x3 = UniformType(GL21.GL_FLOAT_MAT4x3)
        val DOUBLE_MAT2 = UniformType(GL40.GL_DOUBLE_MAT2)
        val DOUBLE_MAT3 = UniformType(GL40.GL_DOUBLE_MAT3)
        val DOUBLE_MAT4 = UniformType(GL40.GL_DOUBLE_MAT4)
        val DOUBLE_MAT2x3 = UniformType(GL40.GL_DOUBLE_MAT2x3)
        val DOUBLE_MAT2x4 = UniformType(GL40.GL_DOUBLE_MAT2x4)
        val DOUBLE_MAT3x2 = UniformType(GL40.GL_DOUBLE_MAT3x2)
        val DOUBLE_MAT3x4 = UniformType(GL40.GL_DOUBLE_MAT3x4)
        val DOUBLE_MAT4x2 = UniformType(GL40.GL_DOUBLE_MAT4x2)
        val DOUBLE_MAT4x3 = UniformType(GL40.GL_DOUBLE_MAT4x3)
        val SAMPLER_1D = UniformType(GL20.GL_SAMPLER_1D)
        val SAMPLER_2D = UniformType(GL20.GL_SAMPLER_2D)
        val SAMPLER_3D = UniformType(GL20.GL_SAMPLER_3D)
        val SAMPLER_CUBE = UniformType(GL20.GL_SAMPLER_CUBE)
        val SAMPLER_1D_SHADOW = UniformType(GL20.GL_SAMPLER_1D_SHADOW)
        val SAMPLER_2D_SHADOW = UniformType(GL20.GL_SAMPLER_2D_SHADOW)
        val SAMPLER_1D_ARRAY_SHADOW = UniformType(GL30.GL_SAMPLER_1D_ARRAY_SHADOW)
        val SAMPLER_2D_ARRAY_SHADOW = UniformType(GL30.GL_SAMPLER_2D_ARRAY_SHADOW)
        val SAMPLER_2D_MULTISAMPLE = UniformType(GL32.GL_SAMPLER_2D_MULTISAMPLE)
        val SAMPLER_2D_MULTISAMPLE_ARRAY = UniformType(GL32.GL_SAMPLER_2D_MULTISAMPLE_ARRAY)
        val SAMPLER_CUBE_SHADOW = UniformType(GL30.GL_SAMPLER_CUBE_SHADOW)
        val SAMPLER_BUFFER = UniformType(GL31.GL_SAMPLER_BUFFER)
        val SAMPLER_2D_RECT = UniformType(GL31.GL_SAMPLER_2D_RECT)
        val SAMPLER_2D_RECT_SHADOW = UniformType(GL31.GL_SAMPLER_2D_RECT_SHADOW)
        val INT_SAMPLER_1D = UniformType(GL30.GL_INT_SAMPLER_1D)
        val INT_SAMPLER_2D = UniformType(GL30.GL_INT_SAMPLER_2D)
        val INT_SAMPLER_3D = UniformType(GL30.GL_INT_SAMPLER_3D)
        val INT_SAMPLER_CUBE = UniformType(GL30.GL_INT_SAMPLER_CUBE)
        val INT_SAMPLER_1D_ARRAY = UniformType(GL30.GL_INT_SAMPLER_1D_ARRAY)
        val INT_SAMPLER_2D_ARRAY = UniformType(GL30.GL_INT_SAMPLER_2D_ARRAY)
        val INT_SAMPLER_2D_MULTISAMPLE = UniformType(GL32.GL_INT_SAMPLER_2D_MULTISAMPLE)
        val INT_SAMPLER_2D_MULTISAMPLE_ARRAY = UniformType(GL32.GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY)
        val INT_SAMPLER_BUFFER = UniformType(GL31.GL_INT_SAMPLER_BUFFER)
        val INT_SAMPLER_2D_RECT = UniformType(GL31.GL_INT_SAMPLER_2D_RECT)
        val UNSIGNED_INT_SAMPLER_1D = UniformType(GL30.GL_UNSIGNED_INT_SAMPLER_1D)
        val UNSIGNED_INT_SAMPLER_2D = UniformType(GL30.GL_UNSIGNED_INT_SAMPLER_2D)
        val UNSIGNED_INT_SAMPLER_3D = UniformType(GL30.GL_UNSIGNED_INT_SAMPLER_3D)
        val UNSIGNED_INT_SAMPLER_CUBE = UniformType(GL30.GL_UNSIGNED_INT_SAMPLER_CUBE)
        val UNSIGNED_INT_SAMPLER_1D_ARRAY = UniformType(GL31.GL_UNSIGNED_INT_SAMPLER_1D_ARRAY)
        val UNSIGNED_INT_SAMPLER_2D_ARRAY = UniformType(GL31.GL_UNSIGNED_INT_SAMPLER_2D_ARRAY)
        val UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = UniformType(GL32.GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE)
        val UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = UniformType(GL32.GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY)
        val UNSIGNED_INT_SAMPLER_BUFFER = UniformType(GL31.GL_UNSIGNED_INT_SAMPLER_BUFFER)
        val UNSIGNED_INT_SAMPLER_2D_RECT = UniformType(GL31.GL_UNSIGNED_INT_SAMPLER_2D_RECT)
        val IMAGE_1D = UniformType(GL42.GL_IMAGE_1D)
        val IMAGE_2D = UniformType(GL42.GL_IMAGE_2D)
        val IMAGE_3D = UniformType(GL42.GL_IMAGE_3D)
        val IMAGE_2D_RECT = UniformType(GL42.GL_IMAGE_2D_RECT)
        val IMAGE_CUBE = UniformType(GL42.GL_IMAGE_CUBE)
        val IMAGE_BUFFER = UniformType(GL42.GL_IMAGE_BUFFER)
        val IMAGE_1D_ARRAY = UniformType(GL42.GL_IMAGE_1D_ARRAY)
        val IMAGE_2D_ARRAY = UniformType(GL42.GL_IMAGE_2D_ARRAY)
        val IMAGE_2D_MULTISAMPLE = UniformType(GL42.GL_IMAGE_2D_MULTISAMPLE)
        val IMAGE_2D_MULTISAMPLE_ARRAY = UniformType(GL42.GL_IMAGE_2D_MULTISAMPLE_ARRAY)
        val INT_IMAGE_1D = UniformType(GL42.GL_INT_IMAGE_1D)
        val INT_IMAGE_2D = UniformType(GL42.GL_INT_IMAGE_2D)
        val INT_IMAGE_3D = UniformType(GL42.GL_INT_IMAGE_3D)
        val INT_IMAGE_2D_RECT = UniformType(GL42.GL_INT_IMAGE_2D_RECT)
        val INT_IMAGE_CUBE = UniformType(GL42.GL_INT_IMAGE_CUBE)
        val INT_IMAGE_BUFFER = UniformType(GL42.GL_INT_IMAGE_BUFFER)
        val INT_IMAGE_1D_ARRAY = UniformType(GL42.GL_INT_IMAGE_1D_ARRAY)
        val INT_IMAGE_2D_ARRAY = UniformType(GL42.GL_INT_IMAGE_2D_ARRAY)
        val INT_IMAGE_2D_MULTISAMPLE = UniformType(GL42.GL_INT_IMAGE_2D_MULTISAMPLE)
        val INT_IMAGE_2D_MULTISAMPLE_ARRAY = UniformType(GL42.GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY)
        val UNSIGNED_INT_IMAGE_1D = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_1D)
        val UNSIGNED_INT_IMAGE_2D = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D)
        val UNSIGNED_INT_IMAGE_3D = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_3D)
        val UNSIGNED_INT_IMAGE_2D_RECT = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D_RECT)
        val UNSIGNED_INT_IMAGE_CUBE = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_CUBE)
        val UNSIGNED_INT_IMAGE_BUFFER = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_BUFFER)
        val UNSIGNED_INT_IMAGE_1D_ARRAY = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_1D_ARRAY)
        val UNSIGNED_INT_IMAGE_2D_ARRAY = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D_ARRAY)
        val UNSIGNED_INT_IMAGE_2D_MULTISAMPLE = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE)
        val UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY)
        val UNSIGNED_INT_ATOMIC_COUNTER = UniformType(GL42.GL_UNSIGNED_INT_ATOMIC_COUNTER)
    }
}

//###############################################################################

@JvmInline
value class VertexAttrType(val i: Int) { // TODO -> VertexAttribType?
    companion object {
        val BYTE = VertexAttrType(GL11.GL_BYTE)
        val UNSIGNED_BYTE = VertexAttrType(GL20.GL_UNSIGNED_BYTE)
        val SHORT = VertexAttrType(GL20.GL_SHORT)
        val UNSIGNED_SHORT = VertexAttrType(GL20.GL_UNSIGNED_SHORT)
        val INT = VertexAttrType(GL11.GL_INT)
        val UNSIGNED_INT = VertexAttrType(GL40.GL_UNSIGNED_INT)
        val HALF_FLOAT = VertexAttrType(GL40.GL_HALF_FLOAT)
        val FLOAT = VertexAttrType(GL40.GL_FLOAT)
        val DOUBLE = VertexAttrType(GL11.GL_DOUBLE)
        val FIXED = VertexAttrType(GL41.GL_FIXED)
        val INT_2_10_10_10_REV = VertexAttrType(GL33.GL_INT_2_10_10_10_REV)
        val UNSIGNED_INT_2_10_10_10_REV = VertexAttrType(GL12.GL_UNSIGNED_INT_2_10_10_10_REV)
        val UNSIGNED_INT_10F_11F_11F_REV = VertexAttrType(GL30.GL_UNSIGNED_INT_10F_11F_11F_REV)
    }
}

//inline class VertexAttribSize(val i: Int) { TODO?
//    companion object {
//        val _1 = VertexAttrType(1)
//        val _2 = VertexAttrType(2)
//        val _3 = VertexAttrType(3)
//        val _4 = VertexAttrType(4)
//    }
//}

//###############################################################################

@JvmInline
value class AttributeType(val i: Int) {
    companion object {
        val FLOAT = AttributeType(GL11.GL_FLOAT)
        val FLOAT_VEC2 = AttributeType(GL20.GL_FLOAT_VEC2)
        val FLOAT_VEC3 = AttributeType(GL20.GL_FLOAT_VEC3)
        val FLOAT_VEC4 = AttributeType(GL20.GL_FLOAT_VEC4)
        val FLOAT_MAT2 = AttributeType(GL20.GL_FLOAT_MAT2)
        val FLOAT_MAT3 = AttributeType(GL20.GL_FLOAT_MAT3)
        val FLOAT_MAT4 = AttributeType(GL20.GL_FLOAT_MAT4)
        val FLOAT_MAT2x3 = AttributeType(GL21.GL_FLOAT_MAT2x3)
        val FLOAT_MAT2x4 = AttributeType(GL21.GL_FLOAT_MAT2x4)
        val FLOAT_MAT3x2 = AttributeType(GL21.GL_FLOAT_MAT3x2)
        val FLOAT_MAT3x4 = AttributeType(GL21.GL_FLOAT_MAT3x4)
        val FLOAT_MAT4x2 = AttributeType(GL21.GL_FLOAT_MAT4x2)
        val FLOAT_MAT4x3 = AttributeType(GL21.GL_FLOAT_MAT4x3)
        val INT_VEC2 = AttributeType(GL20.GL_INT_VEC2)
        val INT_VEC3 = AttributeType(GL20.GL_INT_VEC3)
        val INT_VEC4 = AttributeType(GL20.GL_INT_VEC4)
        val UNSIGNED_INT = AttributeType(GL11.GL_UNSIGNED_INT)
        val UNSIGNED_INT_VEC2 = AttributeType(GL30.GL_UNSIGNED_INT_VEC2)
        val UNSIGNED_INT_VEC3 = AttributeType(GL30.GL_UNSIGNED_INT_VEC3)
        val UNSIGNED_INT_VEC4 = AttributeType(GL30.GL_UNSIGNED_INT_VEC4)
        val DOUBLE = AttributeType(GL11.GL_DOUBLE)
        val DOUBLE_VEC2 = AttributeType(GL40.GL_DOUBLE_VEC2)
        val DOUBLE_VEC3 = AttributeType(GL40.GL_DOUBLE_VEC3)
        val DOUBLE_VEC4 = AttributeType(GL40.GL_DOUBLE_VEC4)
        val DOUBLE_MAT2 = AttributeType(GL40.GL_DOUBLE_MAT2)
        val DOUBLE_MAT3 = AttributeType(GL40.GL_DOUBLE_MAT3)
        val DOUBLE_MAT4 = AttributeType(GL40.GL_DOUBLE_MAT4)
        val DOUBLE_MAT2x3 = AttributeType(GL40.GL_DOUBLE_MAT2x3)
        val DOUBLE_MAT2x4 = AttributeType(GL40.GL_DOUBLE_MAT2x4)
        val DOUBLE_MAT3x2 = AttributeType(GL40.GL_DOUBLE_MAT3x2)
        val DOUBLE_MAT3x4 = AttributeType(GL40.GL_DOUBLE_MAT3x4)
        val DOUBLE_MAT4x2 = AttributeType(GL40.GL_DOUBLE_MAT4x2)
        val DOUBLE_MAT4x3 = AttributeType(GL40.GL_DOUBLE_MAT4x3)
    }
}

//###############################################################################

@JvmInline
value class VertexAttrib(val i: Int) {
    companion object {
        val BUFFER_BINDING = VertexAttrib(GL15.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING)
        val ENABLED = VertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_ENABLED)
        val SIZE = VertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_SIZE)
        val STRIDE = VertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_STRIDE)
        val TYPE = VertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_TYPE)
        val NORMALIZED = VertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED)
        val INTEGER = VertexAttrib(GL30.GL_VERTEX_ATTRIB_ARRAY_INTEGER)
        val DIVISOR = VertexAttrib(GL33.GL_VERTEX_ATTRIB_ARRAY_DIVISOR)
        val CURRENT = VertexAttrib(GL20.GL_CURRENT_VERTEX_ATTRIB)
    }
}

//###############################################################################

@JvmInline
value class ConditionalMode(val i: Int) { // TODO get rid of QUERY_?
    companion object {
        val QUERY_WAIT = ConditionalMode(GL30C.GL_QUERY_WAIT)
        val QUERY_NO_WAIT = ConditionalMode(GL30C.GL_QUERY_NO_WAIT)
        val QUERY_BY_REGION_WAIT = ConditionalMode(GL30C.GL_QUERY_BY_REGION_WAIT)
        val QUERY_BY_REGION_NO_WAIT = ConditionalMode(GL30C.GL_QUERY_BY_REGION_NO_WAIT)
        val QUERY_WAIT_INVERTED = ConditionalMode(GL45C.GL_QUERY_WAIT_INVERTED)
        val QUERY_NO_WAIT_INVERTED = ConditionalMode(GL45C.GL_QUERY_NO_WAIT_INVERTED)
        val QUERY_BY_REGION_WAIT_INVERTED = ConditionalMode(GL45C.GL_QUERY_BY_REGION_WAIT_INVERTED)
        val QUERY_BY_REGION_NO_WAIT_INVERTED = ConditionalMode(GL45C.GL_QUERY_BY_REGION_NO_WAIT_INVERTED)
    }
}

@JvmInline
value class ClampColor(val i: Int) {
    companion object {
        val TRUE = ClampColor(GL30C.GL_TRUE)
        val FALSE = ClampColor(GL30C.GL_FALSE)
        val FIXED_ONLY = ClampColor(GL30C.GL_FIXED_ONLY)
    }
}

@JvmInline
value class GetRenderbuffer(val i: Int) {
    companion object {
        val WIDTH = GetRenderbuffer(GL30C.GL_RENDERBUFFER_WIDTH)
        val HEIGHT = GetRenderbuffer(GL30C.GL_RENDERBUFFER_HEIGHT)
        val INTERNAL_FORMAT = GetRenderbuffer(GL30C.GL_RENDERBUFFER_INTERNAL_FORMAT)
        val SAMPLES = GetRenderbuffer(GL30C.GL_RENDERBUFFER_SAMPLES)
        val RED_SIZE = GetRenderbuffer(GL30C.GL_RENDERBUFFER_RED_SIZE)
        val GREEN_SIZE = GetRenderbuffer(GL30C.GL_RENDERBUFFER_GREEN_SIZE)
        val BLUE_SIZE = GetRenderbuffer(GL30C.GL_RENDERBUFFER_BLUE_SIZE)
        val ALPHA_SIZE = GetRenderbuffer(GL30C.GL_RENDERBUFFER_ALPHA_SIZE)
        val DEPTH_SIZE = GetRenderbuffer(GL30C.GL_RENDERBUFFER_DEPTH_SIZE)
        val STENCIL_SIZE = GetRenderbuffer(GL30C.GL_RENDERBUFFER_STENCIL_SIZE)
    }
}

@JvmInline
value class FramebufferBindTarget(val i: Int) {
    companion object {
        /**  Calling glBindFramebuffer with target set to GL_FRAMEBUFFER binds framebuffer to both the read and draw framebuffer targets. */
        val BOTH = FramebufferBindTarget(GL30C.GL_FRAMEBUFFER)
        val READ = FramebufferBindTarget(GL30C.GL_READ_FRAMEBUFFER)
        val DRAW = FramebufferBindTarget(GL30C.GL_DRAW_FRAMEBUFFER)
    }
}

@JvmInline
value class FramebufferTarget(val i: Int) {
    companion object {
        val READ = FramebufferTarget(GL30C.GL_READ_FRAMEBUFFER)
        /** GL_FRAMEBUFFER is equivalent to GL_DRAW_FRAMEBUFFER */
        val DRAW = FramebufferTarget(GL30C.GL_DRAW_FRAMEBUFFER)
    }
}

@JvmInline
value class GetFramebufferAttachment(val i: Int) {
    companion object {
        val OBJECT_TYPE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE)
        val OBJECT_NAME = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME)
        val RED_SIZE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE)
        val GREEN_SIZE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE)
        val BLUE_SIZE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE)
        val ALPHA_SIZE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE)
        val DEPTH_SIZE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE)
        val STENCIL_SIZE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE)
        val COMPONENT_TYPE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE)
        val COLOR_ENCODING = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING)
        val TEXTURE_LEVEL = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL)
        val TEXTURE_CUBE_MAP_FACE = GetFramebufferAttachment(GL30C.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE)
        val LAYERED = GetFramebufferAttachment(GL32C.GL_FRAMEBUFFER_ATTACHMENT_LAYERED)
        val TEXTURE_LAYER = GetFramebufferAttachment(GL32C.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER)
    }
}

@JvmInline
value class GeometryInputType(val i: Int) {
    companion object {
        val POINTS = GeometryInputType(GL11C.GL_POINTS)
        val LINES = GeometryInputType(GL11C.GL_LINES)
        val LINES_ADJACENCY = GeometryInputType(GL32C.GL_LINES_ADJACENCY)
        val TRIANGLES = GeometryInputType(GL11C.GL_TRIANGLES)
        val TRIANGLES_ADJACENCY = GeometryInputType(GL32C.GL_TRIANGLES_ADJACENCY)
    }
}

@JvmInline
value class GeometryOutputType(val i: Int) {
    companion object {
        val POINTS = GeometryOutputType(GL11C.GL_POINTS)
        val LINE_STRIP = GeometryOutputType(GL11C.GL_LINE_STRIP)
        val TRIANGLE_STRIP = GeometryOutputType(GL32C.GL_TRIANGLE_STRIP)
    }
}

@JvmInline
value class State(val i: Int) {
    companion object {
        val BLEND = State(GL11C.GL_BLEND)
        val CLIP_DISTANCE0 = State(GL30C.GL_CLIP_DISTANCE0)
        val COLOR_LOGIC_OP = State(GL11C.GL_COLOR_LOGIC_OP)
        val CULL_FACE = State(GL11C.GL_CULL_FACE)
        val DEBUG_OUTPUT = State(GL43C.GL_DEBUG_OUTPUT)
        val DEBUG_OUTPUT_SYNCHRONOUS = State(GL43C.GL_DEBUG_OUTPUT_SYNCHRONOUS)
        val DEPTH_CLAMP = State(GL32C.GL_DEPTH_CLAMP)
        val DEPTH_TEST = State(GL11C.GL_DEPTH_TEST)
        val DITHER = State(GL11C.GL_DITHER)
        val FRAMEBUFFER_SRGB = State(GL30C.GL_FRAMEBUFFER_SRGB)
        val LINE_SMOOTH = State(GL11C.GL_LINE_SMOOTH)
        val MULTISAMPLE = State(GL13C.GL_MULTISAMPLE)
        val POLYGON_OFFSET_FILL = State(GL11C.GL_POLYGON_OFFSET_FILL)
        val POLYGON_OFFSET_LINE = State(GL11C.GL_POLYGON_OFFSET_LINE)
        val POLYGON_OFFSET_POINT = State(GL11C.GL_POLYGON_OFFSET_POINT)
        val POLYGON_SMOOTH = State(GL11C.GL_POLYGON_SMOOTH)
        val PRIMITIVE_RESTART = State(GL31C.GL_PRIMITIVE_RESTART)
        val PRIMITIVE_RESTART_FIXED_INDEX = State(GL43C.GL_PRIMITIVE_RESTART_FIXED_INDEX)
        val RASTERIZER_DISCARD = State(GL30C.GL_RASTERIZER_DISCARD)
        val SAMPLE_ALPHA_TO_COVERAGE = State(GL13C.GL_SAMPLE_ALPHA_TO_COVERAGE)
        val SAMPLE_ALPHA_TO_ONE = State(GL13C.GL_SAMPLE_ALPHA_TO_ONE)
        val SAMPLE_COVERAGE = State(GL13C.GL_SAMPLE_COVERAGE)
        val SAMPLE_SHADING = State(GL40C.GL_SAMPLE_SHADING)
        val SAMPLE_MASK = State(GL32C.GL_SAMPLE_MASK)
        val SCISSOR_TEST = State(GL11C.GL_SCISSOR_TEST)
        val STENCIL_TEST = State(GL11C.GL_STENCIL_TEST)
        val TEXTURE_CUBE_MAP_SEAMLESS = State(GL32C.GL_TEXTURE_CUBE_MAP_SEAMLESS)
        val PROGRAM_POINT_SIZE = State(GL32C.GL_PROGRAM_POINT_SIZE)
    }
    operator fun plus(i: Int) = State(this.i + i)
}

@JvmInline
value class IndexedState(val i: Int) {
    companion object {
        val BLEND = IndexedState(GL11C.GL_BLEND)
        val SCISSOR_TEST = IndexedState(GL11C.GL_SCISSOR_TEST)
    }
}

@JvmInline
value class PrimitiveMode(val i: Int) {
    companion object {
        val POINTS = PrimitiveMode(GL11C.GL_POINTS)
        val LINES = PrimitiveMode(GL11C.GL_LINES)
        val TRIANGLES = PrimitiveMode(GL11C.GL_TRIANGLES)
    }
}

@JvmInline
value class TransformBufferMode(val i: Int) {
    companion object {
        val INTERLEAVED_ATTRIBS = TransformBufferMode(GL30C.GL_INTERLEAVED_ATTRIBS)
        val SEPARATE_ATTRIBS = TransformBufferMode(GL30C.GL_SEPARATE_ATTRIBS)
    }
}

@JvmInline
value class IndexType(val i: Int) {
    companion object {
        val UNSIGNED_BYTE = IndexType(GL11C.GL_UNSIGNED_BYTE)
        val UNSIGNED_SHORT = IndexType(GL11C.GL_UNSIGNED_SHORT)
        val UNSIGNED_INT = IndexType(GL11C.GL_UNSIGNED_INT)
    }

    val size: Int
        get() = when (i) {
            GL11.GL_UNSIGNED_BYTE -> Byte.BYTES
            GL11.GL_UNSIGNED_SHORT -> Short.BYTES
            GL11.GL_UNSIGNED_INT -> Int.BYTES
            else -> throw Exception("[IndexType::size] Invalid value")
        }
}

@JvmInline
value class InternalFormat(val i: Int) {
    companion object {
        val R8 = InternalFormat(GL30C.GL_R8)
        val R16 = InternalFormat(GL30C.GL_R16)
        val R16F = InternalFormat(GL30C.GL_R16F)
        val R32F = InternalFormat(GL30C.GL_R32F)
        val R8I = InternalFormat(GL30C.GL_R8I)
        val R16I = InternalFormat(GL30C.GL_R16I)
        val R32I = InternalFormat(GL30C.GL_R32I)
        val R8UI = InternalFormat(GL30C.GL_R8UI)
        val R16UI = InternalFormat(GL30C.GL_R16UI)
        val R32UI = InternalFormat(GL30C.GL_R32UI)
        val RG8 = InternalFormat(GL30C.GL_RG8)
        val RG16 = InternalFormat(GL30C.GL_RG16)
        val RG16F = InternalFormat(GL30C.GL_RG16F)
        val RG32F = InternalFormat(GL30C.GL_RG32F)
        val RG8I = InternalFormat(GL30C.GL_RG8I)
        val RG16I = InternalFormat(GL30C.GL_RG16I)
        val RG32I = InternalFormat(GL30C.GL_RG32I)
        val RG8UI = InternalFormat(GL30C.GL_RG8UI)
        val RG16UI = InternalFormat(GL30C.GL_RG16UI)
        val RGB32F = InternalFormat(GL30C.GL_RGB32F)
        val RGB32I = InternalFormat(GL30C.GL_RGB32I)
        val RGB32UI = InternalFormat(GL30C.GL_RGB32UI)
        val RGBA8 = InternalFormat(GL30C.GL_RGBA8)
        val RGBA16 = InternalFormat(GL30C.GL_RGBA16)
        val RGBA16F = InternalFormat(GL30C.GL_RGBA16F)
        val RGBA32F = InternalFormat(GL30C.GL_RGBA32F)
        val RGBA8I = InternalFormat(GL30C.GL_RGBA8I)
        val RGBA16I = InternalFormat(GL30C.GL_RGBA16I)
        val RGBA32I = InternalFormat(GL30C.GL_RGBA32I)
        val RGBA8UI = InternalFormat(GL30C.GL_RGBA8UI)
        val RGBA16UI = InternalFormat(GL30C.GL_RGBA16UI)
        val RGBA32UI = InternalFormat(GL30C.GL_RGBA32UI)
    }
}

@JvmInline
value class TextureFormat(val i: Int) {
    companion object {
        val RED = TextureFormat(GL44C.GL_RED)
        val RG = TextureFormat(GL44C.GL_RG)
        val RGB = TextureFormat(GL44C.GL_RGB)
        val BGR = TextureFormat(GL44C.GL_BGR)
        val RGBA = TextureFormat(GL44C.GL_RGBA)
        val BGRA = TextureFormat(GL44C.GL_BGRA)
        val RED_INTEGER = TextureFormat(GL44C.GL_RED_INTEGER)
        val RG_INTEGER = TextureFormat(GL44C.GL_RG_INTEGER)
        val RGB_INTEGER = TextureFormat(GL44C.GL_RGB_INTEGER)
        val BGR_INTEGER = TextureFormat(GL44C.GL_BGR_INTEGER)
        val RGBA_INTEGER = TextureFormat(GL44C.GL_RGBA_INTEGER)
        val BGRA_INTEGER = TextureFormat(GL44C.GL_BGRA_INTEGER)
        val STENCIL_INDEX = TextureFormat(GL44C.GL_STENCIL_INDEX)
        val DEPTH_COMPONENT = TextureFormat(GL44C.GL_DEPTH_COMPONENT)
        val DEPTH_STENCIL = TextureFormat(GL44C.GL_DEPTH_STENCIL)
    }
}

// TextureFormat + Green and Blue
@JvmInline
value class TextureFormat2(val i: Int) {
    companion object {
        val RED = TextureFormat2(GL44C.GL_RED)
        val GREEN = TextureFormat2(GL44C.GL_GREEN)
        val BLUE = TextureFormat2(GL44C.GL_BLUE)
        val RG = TextureFormat2(GL44C.GL_RG)
        val RGB = TextureFormat2(GL44C.GL_RGB)
        val BGR = TextureFormat2(GL44C.GL_BGR)
        val RGBA = TextureFormat2(GL44C.GL_RGBA)
        val BGRA = TextureFormat2(GL44C.GL_BGRA)
        val RED_INTEGER = TextureFormat2(GL44C.GL_RED_INTEGER)
        val GREEN_INTEGER = TextureFormat2(GL44C.GL_GREEN_INTEGER)
        val BLUE_INTEGER = TextureFormat2(GL44C.GL_BLUE_INTEGER)
        val RG_INTEGER = TextureFormat2(GL44C.GL_RG_INTEGER)
        val RGB_INTEGER = TextureFormat2(GL44C.GL_RGB_INTEGER)
        val BGR_INTEGER = TextureFormat2(GL44C.GL_BGR_INTEGER)
        val RGBA_INTEGER = TextureFormat2(GL44C.GL_RGBA_INTEGER)
        val BGRA_INTEGER = TextureFormat2(GL44C.GL_BGRA_INTEGER)
        val STENCIL_INDEX = TextureFormat2(GL44C.GL_STENCIL_INDEX)
        val DEPTH_COMPONENT = TextureFormat2(GL44C.GL_DEPTH_COMPONENT)
        val DEPTH_STENCIL = TextureFormat2(GL44C.GL_DEPTH_STENCIL)
    }
}

// for glGetTextureSubImage and glReadnPixel
@JvmInline
value class TextureFormat3(val i: Int) {
    companion object {
        val RED = TextureFormat2(GL44C.GL_RED)
        val RG = TextureFormat2(GL44C.GL_RG)
        val RGB = TextureFormat2(GL44C.GL_RGB)
        val BGR = TextureFormat2(GL44C.GL_BGR)
        val RGBA = TextureFormat2(GL44C.GL_RGBA)
        val BGRA = TextureFormat2(GL44C.GL_BGRA)
        val STENCIL_INDEX = TextureFormat2(GL44C.GL_STENCIL_INDEX)
        val DEPTH_COMPONENT = TextureFormat2(GL44C.GL_DEPTH_COMPONENT)
    }
}

@JvmInline
value class TextureType(val i: Int) {
    companion object {
        val UNSIGNED_BYTE = TextureType(GL44C.GL_UNSIGNED_BYTE)
        val BYTE = TextureType(GL44C.GL_BYTE)
        val UNSIGNED_SHORT = TextureType(GL44C.GL_UNSIGNED_SHORT)
        val SHORT = TextureType(GL44C.GL_SHORT)
        val UNSIGNED_INT = TextureType(GL44C.GL_UNSIGNED_INT)
        val INT = TextureType(GL44C.GL_INT)
        val FLOAT = TextureType(GL44C.GL_FLOAT)
        val UNSIGNED_BYTE_3_3_2 = TextureType(GL44C.GL_UNSIGNED_BYTE_3_3_2)
        val UNSIGNED_BYTE_2_3_3_REV = TextureType(GL44C.GL_UNSIGNED_BYTE_2_3_3_REV)
        val UNSIGNED_SHORT_5_6_5 = TextureType(GL44C.GL_UNSIGNED_SHORT_5_6_5)
        val UNSIGNED_SHORT_5_6_5_REV = TextureType(GL44C.GL_UNSIGNED_SHORT_5_6_5_REV)
        val UNSIGNED_SHORT_4_4_4_4 = TextureType(GL44C.GL_UNSIGNED_SHORT_4_4_4_4)
        val UNSIGNED_SHORT_4_4_4_4_REV = TextureType(GL44C.GL_UNSIGNED_SHORT_4_4_4_4_REV)
        val UNSIGNED_SHORT_5_5_5_1 = TextureType(GL44C.GL_UNSIGNED_SHORT_5_5_5_1)
        val UNSIGNED_SHORT_1_5_5_5_REV = TextureType(GL44C.GL_UNSIGNED_SHORT_1_5_5_5_REV)
        val UNSIGNED_INT_8_8_8_8 = TextureType(GL44C.GL_UNSIGNED_INT_8_8_8_8)
        val UNSIGNED_INT_8_8_8_8_REV = TextureType(GL44C.GL_UNSIGNED_INT_8_8_8_8_REV)
        val UNSIGNED_INT_10_10_10_2 = TextureType(GL44C.GL_UNSIGNED_INT_10_10_10_2)
        val UNSIGNED_INT_2_10_10_10_REV = TextureType(GL44C.GL_UNSIGNED_INT_2_10_10_10_REV)
    }
}

@JvmInline
value class TextureType2(val i: Int) {
    companion object {
        val UNSIGNED_BYTE = TextureType2(GL44C.GL_UNSIGNED_BYTE)
        val BYTE = TextureType2(GL44C.GL_BYTE)
        val UNSIGNED_SHORT = TextureType2(GL44C.GL_UNSIGNED_SHORT)
        val SHORT = TextureType2(GL44C.GL_SHORT)
        val UNSIGNED_INT = TextureType2(GL44C.GL_UNSIGNED_INT)
        val INT = TextureType2(GL44C.GL_INT)
        val FLOAT = TextureType2(GL44C.GL_FLOAT)
        val UNSIGNED_BYTE_3_3_2 = TextureType2(GL44C.GL_UNSIGNED_BYTE_3_3_2)
        val UNSIGNED_BYTE_2_3_3_REV = TextureType2(GL44C.GL_UNSIGNED_BYTE_2_3_3_REV)
        val UNSIGNED_SHORT_5_6_5 = TextureType2(GL44C.GL_UNSIGNED_SHORT_5_6_5)
        val UNSIGNED_SHORT_5_6_5_REV = TextureType2(GL44C.GL_UNSIGNED_SHORT_5_6_5_REV)
        val UNSIGNED_SHORT_4_4_4_4 = TextureType2(GL44C.GL_UNSIGNED_SHORT_4_4_4_4)
        val UNSIGNED_SHORT_4_4_4_4_REV = TextureType2(GL44C.GL_UNSIGNED_SHORT_4_4_4_4_REV)
        val UNSIGNED_SHORT_5_5_5_1 = TextureType2(GL44C.GL_UNSIGNED_SHORT_5_5_5_1)
        val UNSIGNED_SHORT_1_5_5_5_REV = TextureType2(GL44C.GL_UNSIGNED_SHORT_1_5_5_5_REV)
        val UNSIGNED_INT_8_8_8_8 = TextureType2(GL44C.GL_UNSIGNED_INT_8_8_8_8)
        val UNSIGNED_INT_8_8_8_8_REV = TextureType2(GL44C.GL_UNSIGNED_INT_8_8_8_8_REV)
        val UNSIGNED_INT_10_10_10_2 = TextureType2(GL44C.GL_UNSIGNED_INT_10_10_10_2)
        val UNSIGNED_INT_2_10_10_10_REV = TextureType2(GL44C.GL_UNSIGNED_INT_2_10_10_10_REV)
        // news
        val UNSIGNED_INT_24_8 = TextureType2(GL44C.GL_UNSIGNED_INT_24_8)
        val UNSIGNED_INT_10F_11F_11F_REV = TextureType2(GL44C.GL_UNSIGNED_INT_10F_11F_11F_REV)
        val UNSIGNED_INT_5_9_9_9_REV = TextureType2(GL44C.GL_UNSIGNED_INT_5_9_9_9_REV)
        val FLOAT_32_UNSIGNED_INT_24_8_REV = TextureType2(GL44C.GL_FLOAT_32_UNSIGNED_INT_24_8_REV)
    }
}

@JvmInline
value class GetActiveUniform(val i: Int) {
    companion object {
        val UNIFORM_TYPE = GetActiveUniform(GL31C.GL_UNIFORM_TYPE)
        val UNIFORM_SIZE = GetActiveUniform(GL31C.GL_UNIFORM_SIZE)
        val UNIFORM_NAME_LENGTH = GetActiveUniform(GL31C.GL_UNIFORM_NAME_LENGTH)
        val UNIFORM_BLOCK_INDEX = GetActiveUniform(GL31C.GL_UNIFORM_BLOCK_INDEX)
        val UNIFORM_OFFSET = GetActiveUniform(GL31C.GL_UNIFORM_OFFSET)
        val UNIFORM_ARRAY_STRIDE = GetActiveUniform(GL31C.GL_UNIFORM_ARRAY_STRIDE)
        val UNIFORM_MATRIX_STRIDE = GetActiveUniform(GL31C.GL_UNIFORM_MATRIX_STRIDE)
        val UNIFORM_IS_ROW_MAJOR = GetActiveUniform(GL31C.GL_UNIFORM_IS_ROW_MAJOR)
        val UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX = GetActiveUniform(GL42C.GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX)
    }
}

@JvmInline
value class GetActiveUniformBlock(val i: Int) {
    companion object {
        val BINDING = GetActiveUniformBlock(GL31C.GL_UNIFORM_BLOCK_BINDING)
        val DATA_SIZE = GetActiveUniformBlock(GL31C.GL_UNIFORM_BLOCK_DATA_SIZE)
        val NAME_LENGTH = GetActiveUniformBlock(GL31C.GL_UNIFORM_BLOCK_NAME_LENGTH)
        val ACTIVE_UNIFORMS = GetActiveUniformBlock(GL31C.GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS)
        val REFERENCED_BY_VERTEX_SHADER = GetActiveUniformBlock(GL31C.GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER)
        val REFERENCED_BY_TESS_CONTROL_SHADER = GetActiveUniformBlock(GL40C.GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER)
        val REFERENCED_BY_TESS_EVALUATION_SHADER = GetActiveUniformBlock(GL40C.GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER)
        val REFERENCED_BY_GEOMETRY_SHADER = GetActiveUniformBlock(GL31C.GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER)
        val REFERENCED_BY_FRAGMENT_SHADER = GetActiveUniformBlock(GL31C.GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER)
        val REFERENCED_BY_COMPUTE_SHADER = GetActiveUniformBlock(GL43C.GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER)
    }
}

@JvmInline
value class GetActiveAtomicCounterBuffer(val i: Int) {
    companion object {
        val BINDING = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_BINDING)
        val DATA_SIZE = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE)
        val ACTIVE_ATOMIC_COUNTERS = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS)
        val ACTIVE_ATOMIC_COUNTER_INDICES = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES)
        val REFERENCED_BY_VERTEX_SHADER = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER)
        val REFERENCED_BY_TESS_CONTROL_SHADER = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER)
        val REFERENCED_BY_TESS_EVALUATION_SHADER = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER)
        val REFERENCED_BY_GEOMETRY_SHADER = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER)
        val REFERENCED_BY_FRAGMENT_SHADER = GetActiveAtomicCounterBuffer(GL42C.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER)
        val REFERENCED_BY_COMPUTE_SHADER = GetActiveAtomicCounterBuffer(GL43C.GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER)
    }
}

@JvmInline
value class SyncStatus(val i: Int) {
    companion object {
        val ALREADY_SIGNALED = SyncStatus(GL32C.GL_ALREADY_SIGNALED)
        val TIMEOUT_EXPIRED = SyncStatus(GL32C.GL_TIMEOUT_EXPIRED)
        val CONDITION_SATISFIED = SyncStatus(GL32C.GL_CONDITION_SATISFIED)
        val WAIT_FAILED = SyncStatus(GL32C.GL_WAIT_FAILED)
    }
}

@JvmInline
value class GetActiveSubroutineUniform(val i: Int) {
    companion object {
        val NUM_COMPATIBLE_SUBROUTINES = GetActiveSubroutineUniform(GL40C.GL_NUM_COMPATIBLE_SUBROUTINES)
        @Deprecated("use getActiveSubroutineUniformCompatibles instead")
        val COMPATIBLE_SUBROUTINES = GetActiveSubroutineUniform(GL40C.GL_COMPATIBLE_SUBROUTINES)
        val UNIFORM_SIZE = GetActiveSubroutineUniform(GL40C.GL_UNIFORM_SIZE)
        val UNIFORM_NAME_LENGTH = GetActiveSubroutineUniform(GL40C.GL_UNIFORM_NAME_LENGTH)
    }
}

@JvmInline
value class GetProgramStage(val i: Int) {
    companion object {
        val ACTIVE_SUBROUTINE_UNIFORMS = GetProgramStage(GL40C.GL_ACTIVE_SUBROUTINE_UNIFORMS)
        val ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = GetProgramStage(GL40C.GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS)
        val ACTIVE_SUBROUTINES = GetProgramStage(GL40C.GL_ACTIVE_SUBROUTINES)
        val ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = GetProgramStage(GL40C.GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH)
        val ACTIVE_SUBROUTINE_MAX_LENGTH = GetProgramStage(GL40C.GL_ACTIVE_SUBROUTINE_MAX_LENGTH)
    }
}

@JvmInline
value class PatchParameter(val i: Int) {
    companion object {
        @Deprecated("use patchVertices instead")
        val PATCH_VERTICES = PatchParameter(GL40C.GL_PATCH_VERTICES)
        val PATCH_DEFAULT_OUTER_LEVEL = PatchParameter(GL40C.GL_PATCH_DEFAULT_OUTER_LEVEL)
        val PATCH_DEFAULT_INNER_LEVEL = PatchParameter(GL40C.GL_PATCH_DEFAULT_INNER_LEVEL)
    }
}

@JvmInline
value class PrecisionType(val i: Int) {
    companion object {
        val LOW_FLOAT = PrecisionType(GL41C.GL_LOW_FLOAT)
        val MEDIUM_FLOAT = PrecisionType(GL41C.GL_MEDIUM_FLOAT)
        val HIGH_FLOAT = PrecisionType(GL41C.GL_HIGH_FLOAT)
        val LOW_INT = PrecisionType(GL41C.GL_LOW_INT)
        val MEDIUM_INT = PrecisionType(GL41C.GL_MEDIUM_INT)
        val HIGH_INT = PrecisionType(GL41C.GL_HIGH_INT)
    }
}

@JvmInline
value class ProgramParameter(val i: Int) {
    companion object {
        val PROGRAM_BINARY_RETRIEVABLE_HINT = ProgramParameter(GL41C.GL_PROGRAM_BINARY_RETRIEVABLE_HINT)
        val PROGRAM_SEPARABLE = ProgramParameter(GL41C.GL_PROGRAM_SEPARABLE)
    }
}

@JvmInline
value class GetProgramPipeline(val i: Int) {
    companion object {
        val ACTIVE_PROGRAM = GetProgramPipeline(GL41C.GL_ACTIVE_PROGRAM)
        val VERTEX_SHADER = GetProgramPipeline(GL41C.GL_VERTEX_SHADER)
        val TESS_CONTROL_SHADER = GetProgramPipeline(GL41C.GL_TESS_CONTROL_SHADER)
        val TESS_EVALUATION_SHADER = GetProgramPipeline(GL41C.GL_TESS_EVALUATION_SHADER)
        val GEOMETRY_SHADER = GetProgramPipeline(GL41C.GL_GEOMETRY_SHADER)
        val FRAGMENT_SHADER = GetProgramPipeline(GL41C.GL_FRAGMENT_SHADER)
        val INFO_LOG_LENGTH = GetProgramPipeline(GL41C.GL_INFO_LOG_LENGTH)
    }
}

typealias BufferStorageFlags = Int

@JvmInline
value class BufferStorageFlag(val i: Int) {
    companion object {
        val DYNAMIC_STORAGE_BIT = BufferStorageFlag(GL44C.GL_DYNAMIC_STORAGE_BIT)
        val MAP_READ_BIT = BufferStorageFlag(GL44C.GL_MAP_READ_BIT)
        val MAP_WRITE_BIT = BufferStorageFlag(GL44C.GL_MAP_WRITE_BIT)
        val MAP_PERSISTENT_BIT = BufferStorageFlag(GL44C.GL_MAP_PERSISTENT_BIT)
        val MAP_COHERENT_BIT = BufferStorageFlag(GL44C.GL_MAP_COHERENT_BIT)
        val CLIENT_STORAGE_BIT = BufferStorageFlag(GL44C.GL_CLIENT_STORAGE_BIT)
    }
}

typealias MapBufferFlags = Int

@JvmInline
value class MapBufferFlag(val i: Int) {
    companion object {
        val READ_BIT = MapBufferFlag(GL44C.GL_MAP_READ_BIT)
        val WRITE_BIT = MapBufferFlag(GL44C.GL_MAP_WRITE_BIT)
        val PERSISTENT_BIT = MapBufferFlag(GL44C.GL_MAP_PERSISTENT_BIT)
        val COHERENT_BIT = MapBufferFlag(GL44C.GL_MAP_COHERENT_BIT)
        val INVALIDATE_RANGE_BIT = MapBufferFlag(GL44C.GL_MAP_INVALIDATE_RANGE_BIT)
        val INVALIDATE_BUFFER_BIT = MapBufferFlag(GL44C.GL_MAP_INVALIDATE_BUFFER_BIT)
        val FLUSH_EXPLICIT_BIT = MapBufferFlag(GL44C.GL_MAP_FLUSH_EXPLICIT_BIT)
        val UNSYNCHRONIZED_BIT = MapBufferFlag(GL44C.GL_MAP_UNSYNCHRONIZED_BIT)
    }
}


@JvmInline
value class TextureAccess(val i: Int) {
    companion object {
        val READ_ONLY = TextureAccess(GL42C.GL_READ_ONLY)
        val WRITE_ONLY = TextureAccess(GL42C.GL_WRITE_ONLY)
        val READ_WRITE = TextureAccess(GL42C.GL_READ_WRITE)
    }
}

@JvmInline
value class GetInternalFormat(val i: Int) {
    companion object {
        val NUM_SAMPLE_COUNTS = GetInternalFormat(GL42C.GL_NUM_SAMPLE_COUNTS)
        val SAMPLES = GetInternalFormat(GL42C.GL_SAMPLES)
        val INTERNALFORMAT_SUPPORTED = GetInternalFormat(GL43C.GL_INTERNALFORMAT_SUPPORTED)
        val INTERNALFORMAT_PREFERRED = GetInternalFormat(GL43C.GL_INTERNALFORMAT_PREFERRED)
        val INTERNALFORMAT_RED_SIZE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_RED_SIZE)
        val INTERNALFORMAT_GREEN_SIZE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_GREEN_SIZE)
        val INTERNALFORMAT_BLUE_SIZE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_BLUE_SIZE)
        val INTERNALFORMAT_ALPHA_SIZE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_ALPHA_SIZE)
        val INTERNALFORMAT_DEPTH_SIZE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_DEPTH_SIZE)
        val INTERNALFORMAT_STENCIL_SIZE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_STENCIL_SIZE)
        val INTERNALFORMAT_SHARED_SIZE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_SHARED_SIZE)
        val INTERNALFORMAT_RED_TYPE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_RED_TYPE)
        val INTERNALFORMAT_GREEN_TYPE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_GREEN_TYPE)
        val INTERNALFORMAT_BLUE_TYPE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_BLUE_TYPE)
        val INTERNALFORMAT_ALPHA_TYPE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_ALPHA_TYPE)
        val INTERNALFORMAT_DEPTH_TYPE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_DEPTH_TYPE)
        val INTERNALFORMAT_STENCIL_TYPE = GetInternalFormat(GL43C.GL_INTERNALFORMAT_STENCIL_TYPE)
        val MAX_WIDTH = GetInternalFormat(GL43C.GL_MAX_WIDTH)
        val MAX_HEIGHT = GetInternalFormat(GL43C.GL_MAX_HEIGHT)
        val MAX_DEPTH = GetInternalFormat(GL43C.GL_MAX_DEPTH)
        val MAX_LAYERS = GetInternalFormat(GL43C.GL_MAX_LAYERS)
        val MAX_COMBINED_DIMENSIONS = GetInternalFormat(GL43C.GL_MAX_COMBINED_DIMENSIONS)
        val COLOR_COMPONENTS = GetInternalFormat(GL43C.GL_COLOR_COMPONENTS)
        val DEPTH_COMPONENTS = GetInternalFormat(GL43C.GL_DEPTH_COMPONENTS)
        val STENCIL_COMPONENTS = GetInternalFormat(GL43C.GL_STENCIL_COMPONENTS)
        val COLOR_RENDERABLE = GetInternalFormat(GL43C.GL_COLOR_RENDERABLE)
        val DEPTH_RENDERABLE = GetInternalFormat(GL43C.GL_DEPTH_RENDERABLE)
        val STENCIL_RENDERABLE = GetInternalFormat(GL43C.GL_STENCIL_RENDERABLE)
        val FRAMEBUFFER_RENDERABLE = GetInternalFormat(GL43C.GL_FRAMEBUFFER_RENDERABLE)
        val FRAMEBUFFER_RENDERABLE_LAYERED = GetInternalFormat(GL43C.GL_FRAMEBUFFER_RENDERABLE_LAYERED)
        val FRAMEBUFFER_BLEND = GetInternalFormat(GL43C.GL_FRAMEBUFFER_BLEND)
        val READ_PIXELS = GetInternalFormat(GL43C.GL_READ_PIXELS)
        val READ_PIXELS_FORMAT = GetInternalFormat(GL43C.GL_READ_PIXELS_FORMAT)
        val READ_PIXELS_TYPE = GetInternalFormat(GL43C.GL_READ_PIXELS_TYPE)
        val TEXTURE_IMAGE_FORMAT = GetInternalFormat(GL43C.GL_TEXTURE_IMAGE_FORMAT)
        val TEXTURE_IMAGE_TYPE = GetInternalFormat(GL43C.GL_TEXTURE_IMAGE_TYPE)
        val GET_TEXTURE_IMAGE_FORMAT = GetInternalFormat(GL43C.GL_GET_TEXTURE_IMAGE_FORMAT)
        val GET_TEXTURE_IMAGE_TYPE = GetInternalFormat(GL43C.GL_GET_TEXTURE_IMAGE_TYPE)
        val MIPMAP = GetInternalFormat(GL43C.GL_MIPMAP)
        val AUTO_GENERATE_MIPMAP = GetInternalFormat(GL43C.GL_AUTO_GENERATE_MIPMAP)
        val COLOR_ENCODING = GetInternalFormat(GL43C.GL_COLOR_ENCODING)
        val SRGB_READ = GetInternalFormat(GL43C.GL_SRGB_READ)
        val SRGB_WRITE = GetInternalFormat(GL43C.GL_SRGB_WRITE)
        val FILTER = GetInternalFormat(GL43C.GL_FILTER)
        val VERTEX_TEXTURE = GetInternalFormat(GL43C.GL_VERTEX_TEXTURE)
        val TESS_CONTROL_TEXTURE = GetInternalFormat(GL43C.GL_TESS_CONTROL_TEXTURE)
        val TESS_EVALUATION_TEXTURE = GetInternalFormat(GL43C.GL_TESS_EVALUATION_TEXTURE)
        val GEOMETRY_TEXTURE = GetInternalFormat(GL43C.GL_GEOMETRY_TEXTURE)
        val FRAGMENT_TEXTURE = GetInternalFormat(GL43C.GL_FRAGMENT_TEXTURE)
        val COMPUTE_TEXTURE = GetInternalFormat(GL43C.GL_COMPUTE_TEXTURE)
        val TEXTURE_SHADOW = GetInternalFormat(GL43C.GL_TEXTURE_SHADOW)
        val TEXTURE_GATHER = GetInternalFormat(GL43C.GL_TEXTURE_GATHER)
        val TEXTURE_GATHER_SHADOW = GetInternalFormat(GL43C.GL_TEXTURE_GATHER_SHADOW)
        val SHADER_IMAGE_LOAD = GetInternalFormat(GL43C.GL_SHADER_IMAGE_LOAD)
        val SHADER_IMAGE_STORE = GetInternalFormat(GL43C.GL_SHADER_IMAGE_STORE)
        val SHADER_IMAGE_ATOMIC = GetInternalFormat(GL43C.GL_SHADER_IMAGE_ATOMIC)
        val IMAGE_TEXEL_SIZE = GetInternalFormat(GL43C.GL_IMAGE_TEXEL_SIZE)
        val IMAGE_COMPATIBILITY_CLASS = GetInternalFormat(GL43C.GL_IMAGE_COMPATIBILITY_CLASS)
        val IMAGE_PIXEL_FORMAT = GetInternalFormat(GL43C.GL_IMAGE_PIXEL_FORMAT)
        val IMAGE_PIXEL_TYPE = GetInternalFormat(GL43C.GL_IMAGE_PIXEL_TYPE)
        val IMAGE_FORMAT_COMPATIBILITY_TYPE = GetInternalFormat(GL43C.GL_IMAGE_FORMAT_COMPATIBILITY_TYPE)
        val SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = GetInternalFormat(GL43C.GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST)
        val SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = GetInternalFormat(GL43C.GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST)
        val SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = GetInternalFormat(GL43C.GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE)
        val SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = GetInternalFormat(GL43C.GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE)
        val TEXTURE_COMPRESSED = GetInternalFormat(GL43C.GL_TEXTURE_COMPRESSED)
        val TEXTURE_COMPRESSED_BLOCK_WIDTH = GetInternalFormat(GL43C.GL_TEXTURE_COMPRESSED_BLOCK_WIDTH)
        val TEXTURE_COMPRESSED_BLOCK_HEIGHT = GetInternalFormat(GL43C.GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT)
        val TEXTURE_COMPRESSED_BLOCK_SIZE = GetInternalFormat(GL43C.GL_TEXTURE_COMPRESSED_BLOCK_SIZE)
        val CLEAR_BUFFER = GetInternalFormat(GL43C.GL_CLEAR_BUFFER)
        val TEXTURE_VIEW = GetInternalFormat(GL43C.GL_TEXTURE_VIEW)
        val VIEW_COMPATIBILITY_CLASS = GetInternalFormat(GL43C.GL_VIEW_COMPATIBILITY_CLASS)
        val CLEAR_TEXTURE = GetInternalFormat(GL44C.GL_CLEAR_TEXTURE)
    }
}

@JvmInline
value class GlIdentifier(val i: Int) {
    companion object {
        val BUFFER = GlIdentifier(GL43C.GL_BUFFER)
        val SHADER = GlIdentifier(GL43C.GL_SHADER)
        val PROGRAM = GlIdentifier(GL43C.GL_PROGRAM)
        val VERTEX_ARRAY = GlIdentifier(GL43C.GL_VERTEX_ARRAY)
        val QUERY = GlIdentifier(GL43C.GL_QUERY)
        val PROGRAM_PIPELINE = GlIdentifier(GL43C.GL_PROGRAM_PIPELINE)
        val TRANSFORM_FEEDBACK = GlIdentifier(GL43C.GL_TRANSFORM_FEEDBACK)
        val SAMPLER = GlIdentifier(GL43C.GL_SAMPLER)
        val TEXTURE = GlIdentifier(GL11.GL_TEXTURE)
        val RENDERBUFFER = GlIdentifier(GL43C.GL_RENDERBUFFER)
        val FRAMEBUFFER = GlIdentifier(GL43C.GL_FRAMEBUFFER)
    }
}

@JvmInline
value class FramebufferParameter(val i: Int) {
    companion object {
        val DEFAULT_WIDTH = FramebufferParameter(GL43C.GL_FRAMEBUFFER_DEFAULT_WIDTH)
        val DEFAULT_HEIGHT = FramebufferParameter(GL43C.GL_FRAMEBUFFER_DEFAULT_HEIGHT)
        val DEFAULT_LAYERS = FramebufferParameter(GL43C.GL_FRAMEBUFFER_DEFAULT_LAYERS)
        val DEFAULT_SAMPLES = FramebufferParameter(GL43C.GL_FRAMEBUFFER_DEFAULT_SAMPLES)
        val DEFAULT_FIXED_SAMPLE_LOCATIONS = FramebufferParameter(GL43C.GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS)
    }
}

@JvmInline
value class ProgramInterface(val i: Int) {
    companion object {
        val UNIFORM = ProgramInterface(GL43C.GL_UNIFORM)
        val UNIFORM_BLOCK = ProgramInterface(GL43C.GL_UNIFORM_BLOCK)
        val ATOMIC_COUNTER_BUFFER = ProgramInterface(GL43C.GL_ATOMIC_COUNTER_BUFFER)
        val PROGRAM_INPUT = ProgramInterface(GL43C.GL_PROGRAM_INPUT)
        val PROGRAM_OUTPUT = ProgramInterface(GL43C.GL_PROGRAM_OUTPUT)
        val VERTEX_SUBROUTINE = ProgramInterface(GL43C.GL_VERTEX_SUBROUTINE)
        val TESS_CONTROL_SUBROUTINE = ProgramInterface(GL43C.GL_TESS_CONTROL_SUBROUTINE)
        val TESS_EVALUATION_SUBROUTINE = ProgramInterface(GL43C.GL_TESS_EVALUATION_SUBROUTINE)
        val GEOMETRY_SUBROUTINE = ProgramInterface(GL43C.GL_GEOMETRY_SUBROUTINE)
        val FRAGMENT_SUBROUTINE = ProgramInterface(GL43C.GL_FRAGMENT_SUBROUTINE)
        val COMPUTE_SUBROUTINE = ProgramInterface(GL43C.GL_COMPUTE_SUBROUTINE)
        val VERTEX_SUBROUTINE_UNIFORM = ProgramInterface(GL43C.GL_VERTEX_SUBROUTINE_UNIFORM)
        val TESS_CONTROL_SUBROUTINE_UNIFORM = ProgramInterface(GL43C.GL_TESS_CONTROL_SUBROUTINE_UNIFORM)
        val TESS_EVALUATION_SUBROUTINE_UNIFORM = ProgramInterface(GL43C.GL_TESS_EVALUATION_SUBROUTINE_UNIFORM)
        val GEOMETRY_SUBROUTINE_UNIFORM = ProgramInterface(GL43C.GL_GEOMETRY_SUBROUTINE_UNIFORM)
        val FRAGMENT_SUBROUTINE_UNIFORM = ProgramInterface(GL43C.GL_FRAGMENT_SUBROUTINE_UNIFORM)
        val COMPUTE_SUBROUTINE_UNIFORM = ProgramInterface(GL43C.GL_COMPUTE_SUBROUTINE_UNIFORM)
        val TRANSFORM_FEEDBACK_VARYING = ProgramInterface(GL43C.GL_TRANSFORM_FEEDBACK_VARYING)
        val BUFFER_VARIABLE = ProgramInterface(GL43C.GL_BUFFER_VARIABLE)
        val SHADER_STORAGE_BLOCK = ProgramInterface(GL43C.GL_SHADER_STORAGE_BLOCK)
        val TRANSFORM_FEEDBACK_BUFFER = ProgramInterface(GL43C.GL_TRANSFORM_FEEDBACK_BUFFER)
    }
}

@JvmInline
value class GetProgramInterface(val i: Int) {
    companion object {
        val ACTIVE_RESOURCES = GetProgramInterface(GL43C.GL_ACTIVE_RESOURCES)
        val MAX_NAME_LENGTH = GetProgramInterface(GL43C.GL_MAX_NAME_LENGTH)
        val MAX_NUM_ACTIVE_VARIABLES = GetProgramInterface(GL43C.GL_MAX_NUM_ACTIVE_VARIABLES)
        val MAX_NUM_COMPATIBLE_SUBROUTINES = GetProgramInterface(GL43C.GL_MAX_NUM_COMPATIBLE_SUBROUTINES)
    }
}

@JvmInline
value class ControlOrigin(val i: Int) {
    companion object {
        val LOWER_LEFT = ControlOrigin(GL20C.GL_LOWER_LEFT)
        val UPPER_LEFT = ControlOrigin(GL20C.GL_UPPER_LEFT)
    }
}

@JvmInline
value class ClipDepthMode(val i: Int) {
    companion object {
        val NEGATIVE_ONE_TO_ONE = ClipDepthMode(GL45C.GL_NEGATIVE_ONE_TO_ONE)
        val ZERO_TO_ONE = ClipDepthMode(GL45C.GL_ZERO_TO_ONE)
    }
}

@JvmInline
value class GetTransformFeedback(val i: Int) {
    companion object {
        val BUFFER_BINDING = GetTransformFeedbackIndexed(GL45C.GL_TRANSFORM_FEEDBACK_BUFFER_BINDING)
        val PAUSED = GetTransformFeedbackIndexed(GL45C.GL_TRANSFORM_FEEDBACK_PAUSED)
        val ACTIVE = GetTransformFeedbackIndexed(GL45C.GL_TRANSFORM_FEEDBACK_ACTIVE)
    }
}

@JvmInline
value class GetTransformFeedbackIndexed(val i: Int) {
    companion object {
        val BUFFER_BINDING = GetTransformFeedbackIndexed(GL45C.GL_TRANSFORM_FEEDBACK_BUFFER_BINDING)
        val BUFFER_START = GetTransformFeedbackIndexed(GL45C.GL_TRANSFORM_FEEDBACK_BUFFER_START)
        val BUFFER_SIZE = GetTransformFeedbackIndexed(GL45C.GL_TRANSFORM_FEEDBACK_BUFFER_SIZE)
    }
}

@JvmInline
value class FramebufferStatus(val i: Int) {
    val isComplete: Boolean
        get() = this == COMPLETE

    companion object {
        val COMPLETE = FramebufferStatus(GL30C.GL_FRAMEBUFFER_COMPLETE)
        val UNDEFINED = FramebufferStatus(GL30C.GL_FRAMEBUFFER_UNDEFINED)
        val INCOMPLETE_ATTACHMENT = FramebufferStatus(GL30C.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT)
        val INCOMPLETE_MISSING_ATTACHMENT = FramebufferStatus(GL30C.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT)
        val INCOMPLETE_DRAW_BUFFER = FramebufferStatus(GL30C.GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER)
        val INCOMPLETE_READ_BUFFER = FramebufferStatus(GL30C.GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER)
        val UNSUPPORTED = FramebufferStatus(GL30C.GL_FRAMEBUFFER_UNSUPPORTED)
        val INCOMPLETE_MULTISAMPLE = FramebufferStatus(GL30C.GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE)
        val INCOMPLETE_LAYER_TARGETS = FramebufferStatus(GL32C.GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS)
    }
}

@JvmInline
value class FramebufferAttachmentObjectType(val i: Int) {
    companion object {
        val NONE = FramebufferAttachmentObjectType(GL11C.GL_NONE)
        val FRAMEBUFFER_DEFAULT = FramebufferAttachmentObjectType(GL30C.GL_FRAMEBUFFER_DEFAULT)
        val TEXTURE = FramebufferAttachmentObjectType(GL11.GL_TEXTURE)
        val RENDERBUFFER = FramebufferAttachmentObjectType(GL30C.GL_RENDERBUFFER)
    }
}

@JvmInline
value class FramebufferAttachmentComponentType(val i: Int) {
    companion object {
        val FLOAT = FramebufferAttachmentComponentType(GL11C.GL_FLOAT)
        val INT = FramebufferAttachmentComponentType(GL30C.GL_INT)
        val UNSIGNED_INT = FramebufferAttachmentComponentType(GL11.GL_UNSIGNED_INT)
        val SIGNED_NORMALIZED = FramebufferAttachmentComponentType(GL31C.GL_SIGNED_NORMALIZED)
        val UNSIGNED_NORMALIZED = FramebufferAttachmentComponentType(GL30C.GL_UNSIGNED_NORMALIZED)
    }
}

// same as FramebufferAttachmentComponentType + None
@JvmInline
value class TextureComponentType(val i: Int) {
    companion object {
        val NONE = TextureComponentType(GL11C.GL_NONE)
        val FLOAT = TextureComponentType(GL11C.GL_FLOAT)
        val INT = TextureComponentType(GL30C.GL_INT)
        val UNSIGNED_INT = TextureComponentType(GL11.GL_UNSIGNED_INT)
        val SIGNED_NORMALIZED = TextureComponentType(GL31C.GL_SIGNED_NORMALIZED)
        val UNSIGNED_NORMALIZED = TextureComponentType(GL30C.GL_UNSIGNED_NORMALIZED)
    }
}

@JvmInline
value class FramebufferAttachmentColorEncoding(val i: Int) {
    companion object {
        val LINEAR = FramebufferAttachmentColorEncoding(GL11C.GL_LINEAR)
        val SRGB = FramebufferAttachmentColorEncoding(GL21C.GL_SRGB)
    }
}

@JvmInline
value class GraphicsResetStatus(val i: Int) { // TODO -> GraphicContextReset and remove _CONTEXT_RESET?
    companion object {
        val NO_ERROR = GraphicsResetStatus(GL11C.GL_NO_ERROR)
        val GUILTY_CONTEXT_RESET = GraphicsResetStatus(GL45C.GL_GUILTY_CONTEXT_RESET)
        val INNOCENT_CONTEXT_RESET = GraphicsResetStatus(GL45C.GL_INNOCENT_CONTEXT_RESET)
        val UNKNOWN_CONTEXT_RESET = GraphicsResetStatus(GL45C.GL_UNKNOWN_CONTEXT_RESET)
    }
}

@JvmInline
value class ColorEncoding(val i: Int) {
    companion object {
        val SRGB = ColorEncoding(GL21C.GL_SRGB)
        val LINEAR = ColorEncoding(GL21C.GL_LINEAR)
    }
}