package com.kingdee.attendance.dto;

// 错误码列表
public enum ErrorCode {
	SUCCESS(0, "OK"), PERMISSION_DENINED(401, "没有权限"), SERVER_ERROR(500, "服务异常"), PARAM_ERROR(1001,
			"参数错误"), UPDATE_ERROR(1002, "修改失败"), DEL_ERROR(1003, "删除失败"), LOCK_ERROR(1004, "获取锁失败，请稍候再试");

	private int key;
	private String value;

	ErrorCode(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int key() {
		return this.key;
	}

	public String value() {
		return this.value;
	}
}
