/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengles;

import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import java.util.Set;
import java.util.HashSet;

public class ContextCapabilities {
	static final boolean DEBUG = false;

	private static boolean loaded_stubs;
	public final boolean GL_AMD_compressed_3DC_texture;
	public final boolean GL_AMD_compressed_ATC_texture;
	public final boolean GL_AMD_performance_monitor;
	public final boolean GL_AMD_program_binary_Z400;
	public final boolean GL_ANGLE_framebuffer_blit;
	public final boolean GL_ANGLE_framebuffer_multisample;
	public final boolean GL_APPLE_framebuffer_multisample;
	public final boolean GL_APPLE_rgb_422;
	public final boolean GL_APPLE_texture_format_BGRA8888;
	public final boolean GL_APPLE_texture_max_level;
	public final boolean GL_ARB_draw_buffers;
	public final boolean GL_ARB_half_float_pixel;
	public final boolean GL_ARB_texture_rectangle;
	public final boolean GL_ARM_mali_shader_binary;
	public final boolean GL_ARM_rgba8;
	public final boolean GL_DMP_shader_binary;
	public final boolean GL_EXT_Cg_shader;
	public final boolean GL_EXT_bgra;
	public final boolean GL_EXT_blend_minmax;
	public final boolean GL_EXT_color_buffer_half_float;
	public final boolean GL_EXT_debug_label;
	public final boolean GL_EXT_debug_marker;
	public final boolean GL_EXT_discard_framebuffer;
	public final boolean GL_EXT_frag_depth;
	public final boolean GL_EXT_multi_draw_arrays;
	public final boolean GL_EXT_multisampled_render_to_texture;
	public final boolean GL_EXT_occlusion_query_boolean;
	public final boolean GL_EXT_packed_float;
	public final boolean GL_EXT_read_format_bgra;
	public final boolean GL_EXT_robustness;
	public final boolean GL_EXT_sRGB;
	public final boolean GL_EXT_separate_shader_objects;
	public final boolean GL_EXT_shader_texture_lod;
	public final boolean GL_EXT_shadow_samplers;
	public final boolean GL_EXT_texture_array;
	public final boolean GL_EXT_texture_compression_dxt1;
	public final boolean GL_EXT_texture_compression_latc;
	public final boolean GL_EXT_texture_compression_s3tc;
	public final boolean GL_EXT_texture_filter_anisotropic;
	public final boolean GL_EXT_texture_format_BGRA8888;
	public final boolean GL_EXT_texture_lod_bias;
	public final boolean GL_EXT_texture_rg;
	public final boolean GL_EXT_texture_storage;
	public final boolean GL_EXT_texture_type_2_10_10_10_REV;
	public final boolean GL_EXT_unpack_subimage;
	public final boolean OpenGLES20;
	public final boolean GL_IMG_multisampled_render_to_texture;
	public final boolean GL_IMG_program_binary;
	public final boolean GL_IMG_read_format;
	public final boolean GL_IMG_shader_binary;
	public final boolean GL_IMG_texture_compression_pvrtc;
	public final boolean GL_NV_EGL_stream_consumer_external;
	public final boolean GL_NV_coverage_sample;
	public final boolean GL_NV_depth_nonlinear;
	public final boolean GL_NV_draw_buffers;
	public final boolean GL_NV_draw_path;
	public final boolean GL_NV_fbo_color_attachments;
	public final boolean GL_NV_fence;
	public final boolean GL_NV_framebuffer_vertex_attrib_array;
	public final boolean GL_NV_get_tex_image;
	public final boolean GL_NV_platform_binary;
	public final boolean GL_NV_read_buffer;
	public final boolean GL_NV_read_depth_stencil;
	public final boolean GL_NV_shader_framebuffer_fetch;
	public final boolean GL_NV_system_time;
	public final boolean GL_NV_texture_compression_s3tc_update;
	public final boolean GL_NV_texture_npot_2D_mipmap;
	public final boolean GL_OES_EGL_image;
	public final boolean GL_OES_EGL_image_external;
	public final boolean GL_OES_EGL_sync;
	public final boolean GL_OES_blend_equation_separate;
	public final boolean GL_OES_blend_func_separate;
	public final boolean GL_OES_blend_subtract;
	public final boolean GL_OES_compressed_ETC1_RGB8_texture;
	public final boolean GL_OES_compressed_paletted_texture;
	public final boolean GL_OES_depth24;
	public final boolean GL_OES_depth32;
	public final boolean GL_OES_depth_texture;
	public final boolean GL_OES_element_index_uint;
	public final boolean GL_OES_fbo_render_mipmap;
	public final boolean GL_OES_framebuffer_object;
	public final boolean GL_OES_get_program_binary;
	public final boolean GL_OES_mapbuffer;
	public final boolean GL_OES_packed_depth_stencil;
	public final boolean GL_OES_rgb8_rgba8;
	public final boolean GL_OES_standard_derivatives;
	public final boolean GL_OES_stencil1;
	public final boolean GL_OES_stencil4;
	public final boolean GL_OES_stencil8;
	public final boolean GL_OES_texture_3D;
	public final boolean GL_OES_texture_float;
	public final boolean GL_OES_texture_float_linear;
	public final boolean GL_OES_texture_half_float;
	public final boolean GL_OES_texture_half_float_linear;
	public final boolean GL_OES_texture_npot;
	public final boolean GL_OES_vertex_array_object;
	public final boolean GL_OES_vertex_half_float;
	public final boolean GL_OES_vertex_type_10_10_10_2;
	public final boolean GL_QCOM_driver_control;
	public final boolean GL_QCOM_extended_get;
	public final boolean GL_QCOM_extended_get2;
	public final boolean GL_QCOM_performance_monitor_global_mode;
	public final boolean GL_QCOM_tiled_rendering;
	public final boolean GL_QCOM_writeonly_rendering;
	public final boolean GL_VIV_shader_binary;

	private Set<String> initAllStubs() throws LWJGLException {
		GLContext.setCapabilities(this);
		Set<String> supported_extensions = new HashSet<String>(256);
		GLContext.doInitNativeStubs(GLES20.class);
		GLContext.getSupportedExtensions(supported_extensions);
		if (loaded_stubs)
			return supported_extensions;
		GLContext.initNativeStubs(AMDPerformanceMonitor.class, supported_extensions, "GL_AMD_performance_monitor");
		GLContext.initNativeStubs(ANGLEFramebufferBlit.class, supported_extensions, "GL_ANGLE_framebuffer_blit");
		GLContext.initNativeStubs(ANGLEFramebufferMultisample.class, supported_extensions, "GL_ANGLE_framebuffer_multisample");
		GLContext.initNativeStubs(APPLEFramebufferMultisample.class, supported_extensions, "GL_APPLE_framebuffer_multisample");
		GLContext.initNativeStubs(ARBDrawBuffers.class, supported_extensions, "GL_ARB_draw_buffers");
		GLContext.initNativeStubs(EXTBlendMinmax.class, supported_extensions, "GL_EXT_blend_minmax");
		GLContext.initNativeStubs(EXTDebugLabel.class, supported_extensions, "GL_EXT_debug_label");
		GLContext.initNativeStubs(EXTDebugMarker.class, supported_extensions, "GL_EXT_debug_marker");
		GLContext.initNativeStubs(EXTDiscardFramebuffer.class, supported_extensions, "GL_EXT_discard_framebuffer");
		GLContext.initNativeStubs(EXTMultiDrawArrays.class, supported_extensions, "GL_EXT_multi_draw_arrays");
		GLContext.initNativeStubs(EXTMultisampledRenderToTexture.class, supported_extensions, "GL_EXT_multisampled_render_to_texture");
		GLContext.initNativeStubs(EXTOcclusionQueryBoolean.class, supported_extensions, "GL_EXT_occlusion_query_boolean");
		GLContext.initNativeStubs(EXTRobustness.class, supported_extensions, "GL_EXT_robustness");
		GLContext.initNativeStubs(EXTSeparateShaderObjects.class, supported_extensions, "GL_EXT_separate_shader_objects");
		GLContext.initNativeStubs(EXTTextureArray.class, supported_extensions, "GL_EXT_texture_array");
		GLContext.initNativeStubs(EXTTextureStorage.class, supported_extensions, "GL_EXT_texture_storage");
		GLContext.initNativeStubs(IMGMultisampledRenderToTexture.class, supported_extensions, "GL_IMG_multisampled_render_to_texture");
		GLContext.initNativeStubs(NVCoverageSample.class, supported_extensions, "GL_NV_coverage_sample");
		GLContext.initNativeStubs(NVDrawBuffers.class, supported_extensions, "GL_NV_draw_buffers");
		GLContext.initNativeStubs(NVDrawPath.class, supported_extensions, "GL_NV_draw_path");
		GLContext.initNativeStubs(NVFence.class, supported_extensions, "GL_NV_fence");
		GLContext.initNativeStubs(NVFramebufferVertexAttribArray.class, supported_extensions, "GL_NV_framebuffer_vertex_attrib_array");
		GLContext.initNativeStubs(NVGetTexImage.class, supported_extensions, "GL_NV_get_tex_image");
		GLContext.initNativeStubs(NVReadBuffer.class, supported_extensions, "GL_NV_read_buffer");
		GLContext.initNativeStubs(NVSystemTime.class, supported_extensions, "GL_NV_system_time");
		GLContext.initNativeStubs(OESEGLImage.class, supported_extensions, "GL_OES_EGL_image");
		GLContext.initNativeStubs(OESEGLImageExternal.class, supported_extensions, "GL_OES_EGL_image_external");
		GLContext.initNativeStubs(OESBlendEquationSeparate.class, supported_extensions, "GL_OES_blend_equation_separate");
		GLContext.initNativeStubs(OESBlendFuncSeparate.class, supported_extensions, "GL_OES_blend_func_separate");
		GLContext.initNativeStubs(OESBlendSubtract.class, supported_extensions, "GL_OES_blend_subtract");
		GLContext.initNativeStubs(OESFramebufferObject.class, supported_extensions, "GL_OES_framebuffer_object");
		GLContext.initNativeStubs(OESGetProgramBinary.class, supported_extensions, "GL_OES_get_program_binary");
		GLContext.initNativeStubs(OESMapbuffer.class, supported_extensions, "GL_OES_mapbuffer");
		GLContext.initNativeStubs(OESTexture3D.class, supported_extensions, "GL_OES_texture_3D");
		GLContext.initNativeStubs(OESVertexArrayObject.class, supported_extensions, "GL_OES_vertex_array_object");
		GLContext.initNativeStubs(QCOMDriverControl.class, supported_extensions, "GL_QCOM_driver_control");
		GLContext.initNativeStubs(QCOMExtendedGet.class, supported_extensions, "GL_QCOM_extended_get");
		GLContext.initNativeStubs(QCOMExtendedGet2.class, supported_extensions, "GL_QCOM_extended_get2");
		GLContext.initNativeStubs(QCOMTiledRendering.class, supported_extensions, "GL_QCOM_tiled_rendering");
		loaded_stubs = true;
		return supported_extensions;
	}

	static void unloadAllStubs() {
		if (!loaded_stubs)
			return;
		GLContext.resetNativeStubs(AMDPerformanceMonitor.class);
		GLContext.resetNativeStubs(ANGLEFramebufferBlit.class);
		GLContext.resetNativeStubs(ANGLEFramebufferMultisample.class);
		GLContext.resetNativeStubs(APPLEFramebufferMultisample.class);
		GLContext.resetNativeStubs(ARBDrawBuffers.class);
		GLContext.resetNativeStubs(EXTBlendMinmax.class);
		GLContext.resetNativeStubs(EXTDebugLabel.class);
		GLContext.resetNativeStubs(EXTDebugMarker.class);
		GLContext.resetNativeStubs(EXTDiscardFramebuffer.class);
		GLContext.resetNativeStubs(EXTMultiDrawArrays.class);
		GLContext.resetNativeStubs(EXTMultisampledRenderToTexture.class);
		GLContext.resetNativeStubs(EXTOcclusionQueryBoolean.class);
		GLContext.resetNativeStubs(EXTRobustness.class);
		GLContext.resetNativeStubs(EXTSeparateShaderObjects.class);
		GLContext.resetNativeStubs(EXTTextureArray.class);
		GLContext.resetNativeStubs(EXTTextureStorage.class);
		GLContext.resetNativeStubs(IMGMultisampledRenderToTexture.class);
		GLContext.resetNativeStubs(NVCoverageSample.class);
		GLContext.resetNativeStubs(NVDrawBuffers.class);
		GLContext.resetNativeStubs(NVDrawPath.class);
		GLContext.resetNativeStubs(NVFence.class);
		GLContext.resetNativeStubs(NVFramebufferVertexAttribArray.class);
		GLContext.resetNativeStubs(NVGetTexImage.class);
		GLContext.resetNativeStubs(NVReadBuffer.class);
		GLContext.resetNativeStubs(NVSystemTime.class);
		GLContext.resetNativeStubs(OESEGLImage.class);
		GLContext.resetNativeStubs(OESEGLImageExternal.class);
		GLContext.resetNativeStubs(OESBlendEquationSeparate.class);
		GLContext.resetNativeStubs(OESBlendFuncSeparate.class);
		GLContext.resetNativeStubs(OESBlendSubtract.class);
		GLContext.resetNativeStubs(OESFramebufferObject.class);
		GLContext.resetNativeStubs(OESGetProgramBinary.class);
		GLContext.resetNativeStubs(OESMapbuffer.class);
		GLContext.resetNativeStubs(OESTexture3D.class);
		GLContext.resetNativeStubs(OESVertexArrayObject.class);
		GLContext.resetNativeStubs(QCOMDriverControl.class);
		GLContext.resetNativeStubs(QCOMExtendedGet.class);
		GLContext.resetNativeStubs(QCOMExtendedGet2.class);
		GLContext.resetNativeStubs(QCOMTiledRendering.class);
		loaded_stubs = false;
	}

	ContextCapabilities() throws LWJGLException {
		Set<String> supported_extensions = initAllStubs();
		this.GL_AMD_compressed_3DC_texture = supported_extensions.contains("GL_AMD_compressed_3DC_texture");
		this.GL_AMD_compressed_ATC_texture = supported_extensions.contains("GL_AMD_compressed_ATC_texture");
		this.GL_AMD_performance_monitor = supported_extensions.contains("GL_AMD_performance_monitor");
		this.GL_AMD_program_binary_Z400 = supported_extensions.contains("GL_AMD_program_binary_Z400");
		this.GL_ANGLE_framebuffer_blit = supported_extensions.contains("GL_ANGLE_framebuffer_blit");
		this.GL_ANGLE_framebuffer_multisample = supported_extensions.contains("GL_ANGLE_framebuffer_multisample");
		this.GL_APPLE_framebuffer_multisample = supported_extensions.contains("GL_APPLE_framebuffer_multisample");
		this.GL_APPLE_rgb_422 = supported_extensions.contains("GL_APPLE_rgb_422");
		this.GL_APPLE_texture_format_BGRA8888 = supported_extensions.contains("GL_APPLE_texture_format_BGRA8888");
		this.GL_APPLE_texture_max_level = supported_extensions.contains("GL_APPLE_texture_max_level");
		this.GL_ARB_draw_buffers = supported_extensions.contains("GL_ARB_draw_buffers");
		this.GL_ARB_half_float_pixel = supported_extensions.contains("GL_ARB_half_float_pixel");
		this.GL_ARB_texture_rectangle = supported_extensions.contains("GL_ARB_texture_rectangle");
		this.GL_ARM_mali_shader_binary = supported_extensions.contains("GL_ARM_mali_shader_binary");
		this.GL_ARM_rgba8 = supported_extensions.contains("GL_ARM_rgba8");
		this.GL_DMP_shader_binary = supported_extensions.contains("GL_DMP_shader_binary");
		this.GL_EXT_Cg_shader = supported_extensions.contains("GL_EXT_Cg_shader");
		this.GL_EXT_bgra = supported_extensions.contains("GL_EXT_bgra");
		this.GL_EXT_blend_minmax = supported_extensions.contains("GL_EXT_blend_minmax");
		this.GL_EXT_color_buffer_half_float = supported_extensions.contains("GL_EXT_color_buffer_half_float");
		this.GL_EXT_debug_label = supported_extensions.contains("GL_EXT_debug_label");
		this.GL_EXT_debug_marker = supported_extensions.contains("GL_EXT_debug_marker");
		this.GL_EXT_discard_framebuffer = supported_extensions.contains("GL_EXT_discard_framebuffer");
		this.GL_EXT_frag_depth = supported_extensions.contains("GL_EXT_frag_depth");
		this.GL_EXT_multi_draw_arrays = supported_extensions.contains("GL_EXT_multi_draw_arrays");
		this.GL_EXT_multisampled_render_to_texture = supported_extensions.contains("GL_EXT_multisampled_render_to_texture");
		this.GL_EXT_occlusion_query_boolean = supported_extensions.contains("GL_EXT_occlusion_query_boolean");
		this.GL_EXT_packed_float = supported_extensions.contains("GL_EXT_packed_float");
		this.GL_EXT_read_format_bgra = supported_extensions.contains("GL_EXT_read_format_bgra");
		this.GL_EXT_robustness = supported_extensions.contains("GL_EXT_robustness");
		this.GL_EXT_sRGB = supported_extensions.contains("GL_EXT_sRGB");
		this.GL_EXT_separate_shader_objects = supported_extensions.contains("GL_EXT_separate_shader_objects");
		this.GL_EXT_shader_texture_lod = supported_extensions.contains("GL_EXT_shader_texture_lod");
		this.GL_EXT_shadow_samplers = supported_extensions.contains("GL_EXT_shadow_samplers");
		this.GL_EXT_texture_array = supported_extensions.contains("GL_EXT_texture_array");
		this.GL_EXT_texture_compression_dxt1 = supported_extensions.contains("GL_EXT_texture_compression_dxt1");
		this.GL_EXT_texture_compression_latc = supported_extensions.contains("GL_EXT_texture_compression_latc");
		this.GL_EXT_texture_compression_s3tc = supported_extensions.contains("GL_EXT_texture_compression_s3tc");
		this.GL_EXT_texture_filter_anisotropic = supported_extensions.contains("GL_EXT_texture_filter_anisotropic");
		this.GL_EXT_texture_format_BGRA8888 = supported_extensions.contains("GL_EXT_texture_format_BGRA8888");
		this.GL_EXT_texture_lod_bias = supported_extensions.contains("GL_EXT_texture_lod_bias");
		this.GL_EXT_texture_rg = supported_extensions.contains("GL_EXT_texture_rg");
		this.GL_EXT_texture_storage = supported_extensions.contains("GL_EXT_texture_storage");
		this.GL_EXT_texture_type_2_10_10_10_REV = supported_extensions.contains("GL_EXT_texture_type_2_10_10_10_REV");
		this.GL_EXT_unpack_subimage = supported_extensions.contains("GL_EXT_unpack_subimage");
		this.OpenGLES20 = supported_extensions.contains("OpenGLES20");
		this.GL_IMG_multisampled_render_to_texture = supported_extensions.contains("GL_IMG_multisampled_render_to_texture");
		this.GL_IMG_program_binary = supported_extensions.contains("GL_IMG_program_binary");
		this.GL_IMG_read_format = supported_extensions.contains("GL_IMG_read_format");
		this.GL_IMG_shader_binary = supported_extensions.contains("GL_IMG_shader_binary");
		this.GL_IMG_texture_compression_pvrtc = supported_extensions.contains("GL_IMG_texture_compression_pvrtc");
		this.GL_NV_EGL_stream_consumer_external = supported_extensions.contains("GL_NV_EGL_stream_consumer_external");
		this.GL_NV_coverage_sample = supported_extensions.contains("GL_NV_coverage_sample");
		this.GL_NV_depth_nonlinear = supported_extensions.contains("GL_NV_depth_nonlinear");
		this.GL_NV_draw_buffers = supported_extensions.contains("GL_NV_draw_buffers");
		this.GL_NV_draw_path = supported_extensions.contains("GL_NV_draw_path");
		this.GL_NV_fbo_color_attachments = supported_extensions.contains("GL_NV_fbo_color_attachments");
		this.GL_NV_fence = supported_extensions.contains("GL_NV_fence");
		this.GL_NV_framebuffer_vertex_attrib_array = supported_extensions.contains("GL_NV_framebuffer_vertex_attrib_array");
		this.GL_NV_get_tex_image = supported_extensions.contains("GL_NV_get_tex_image");
		this.GL_NV_platform_binary = supported_extensions.contains("GL_NV_platform_binary");
		this.GL_NV_read_buffer = supported_extensions.contains("GL_NV_read_buffer");
		this.GL_NV_read_depth_stencil = supported_extensions.contains("GL_NV_read_depth_stencil");
		this.GL_NV_shader_framebuffer_fetch = supported_extensions.contains("GL_NV_shader_framebuffer_fetch");
		this.GL_NV_system_time = supported_extensions.contains("GL_NV_system_time");
		this.GL_NV_texture_compression_s3tc_update = supported_extensions.contains("GL_NV_texture_compression_s3tc_update");
		this.GL_NV_texture_npot_2D_mipmap = supported_extensions.contains("GL_NV_texture_npot_2D_mipmap");
		this.GL_OES_EGL_image = supported_extensions.contains("GL_OES_EGL_image");
		this.GL_OES_EGL_image_external = supported_extensions.contains("GL_OES_EGL_image_external");
		this.GL_OES_EGL_sync = supported_extensions.contains("GL_OES_EGL_sync")
			|| supported_extensions.contains("GL_OES_egl_sync");
		this.GL_OES_blend_equation_separate = supported_extensions.contains("GL_OES_blend_equation_separate");
		this.GL_OES_blend_func_separate = supported_extensions.contains("GL_OES_blend_func_separate");
		this.GL_OES_blend_subtract = supported_extensions.contains("GL_OES_blend_subtract");
		this.GL_OES_compressed_ETC1_RGB8_texture = supported_extensions.contains("GL_OES_compressed_ETC1_RGB8_texture");
		this.GL_OES_compressed_paletted_texture = supported_extensions.contains("GL_OES_compressed_paletted_texture");
		this.GL_OES_depth24 = supported_extensions.contains("GL_OES_depth24");
		this.GL_OES_depth32 = supported_extensions.contains("GL_OES_depth32");
		this.GL_OES_depth_texture = supported_extensions.contains("GL_OES_depth_texture");
		this.GL_OES_element_index_uint = supported_extensions.contains("GL_OES_element_index_uint");
		this.GL_OES_fbo_render_mipmap = supported_extensions.contains("GL_OES_fbo_render_mipmap");
		this.GL_OES_framebuffer_object = supported_extensions.contains("GL_OES_framebuffer_object");
		this.GL_OES_get_program_binary = supported_extensions.contains("GL_OES_get_program_binary");
		this.GL_OES_mapbuffer = supported_extensions.contains("GL_OES_mapbuffer");
		this.GL_OES_packed_depth_stencil = supported_extensions.contains("GL_OES_packed_depth_stencil");
		this.GL_OES_rgb8_rgba8 = supported_extensions.contains("GL_OES_rgb8_rgba8");
		this.GL_OES_standard_derivatives = supported_extensions.contains("GL_OES_standard_derivatives");
		this.GL_OES_stencil1 = supported_extensions.contains("GL_OES_stencil1");
		this.GL_OES_stencil4 = supported_extensions.contains("GL_OES_stencil4");
		this.GL_OES_stencil8 = supported_extensions.contains("GL_OES_stencil8");
		this.GL_OES_texture_3D = supported_extensions.contains("GL_OES_texture_3D");
		this.GL_OES_texture_float = supported_extensions.contains("GL_OES_texture_float");
		this.GL_OES_texture_float_linear = supported_extensions.contains("GL_OES_texture_float_linear");
		this.GL_OES_texture_half_float = supported_extensions.contains("GL_OES_texture_half_float");
		this.GL_OES_texture_half_float_linear = supported_extensions.contains("GL_OES_texture_half_float_linear");
		this.GL_OES_texture_npot = supported_extensions.contains("GL_OES_texture_npot");
		this.GL_OES_vertex_array_object = supported_extensions.contains("GL_OES_vertex_array_object");
		this.GL_OES_vertex_half_float = supported_extensions.contains("GL_OES_vertex_half_float");
		this.GL_OES_vertex_type_10_10_10_2 = supported_extensions.contains("GL_OES_vertex_type_10_10_10_2");
		this.GL_QCOM_driver_control = supported_extensions.contains("GL_QCOM_driver_control");
		this.GL_QCOM_extended_get = supported_extensions.contains("GL_QCOM_extended_get");
		this.GL_QCOM_extended_get2 = supported_extensions.contains("GL_QCOM_extended_get2");
		this.GL_QCOM_performance_monitor_global_mode = supported_extensions.contains("GL_QCOM_performance_monitor_global_mode");
		this.GL_QCOM_tiled_rendering = supported_extensions.contains("GL_QCOM_tiled_rendering");
		this.GL_QCOM_writeonly_rendering = supported_extensions.contains("GL_QCOM_writeonly_rendering");
		this.GL_VIV_shader_binary = supported_extensions.contains("GL_VIV_shader_binary");
	}
}
