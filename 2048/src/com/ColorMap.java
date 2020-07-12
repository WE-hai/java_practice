package com;

import java.awt.Color;
import java.util.HashMap;

public class ColorMap {
	public static HashMap<Integer, ColorTuple> colorMap = new HashMap<>();
	//设置2,4,6,8等数字的颜色，各不相同，便于区分和识别
	static {
		colorMap.put(0, new ColorTuple(new Color(205, 193, 180), new Color(205, 193, 180)));
		colorMap.put(2, new ColorTuple(new Color(238, 228, 218), new Color(119, 110, 101)));
		colorMap.put(4, new ColorTuple(new Color(237, 223, 196), new Color(119, 110, 101)));
		colorMap.put(8, new ColorTuple(new Color(242, 177, 121), new Color(249, 246, 242)));
		colorMap.put(16, new ColorTuple(new Color(244, 151, 100), new Color(249, 246, 242)));
		colorMap.put(32, new ColorTuple(new Color(246, 124, 95), new Color(249, 246, 242)));
		colorMap.put(64, new ColorTuple(new Color(246, 94, 59), new Color(249, 246, 242)));
		colorMap.put(128, new ColorTuple(new Color(237, 207, 114), new Color(249, 246, 242)));
		colorMap.put(256, new ColorTuple(new Color(237, 204, 97), new Color(249, 246, 242)));
		colorMap.put(512, new ColorTuple(new Color(237, 200, 80), new Color(249, 246, 242)));
		colorMap.put(1024, new ColorTuple(new Color(237, 197, 63), new Color(249, 246, 242)));
		colorMap.put(2048, new ColorTuple(new Color(237, 194, 46), new Color(249, 246, 242)));
		colorMap.put(4096, new ColorTuple(new Color(60, 58, 50), new Color(249, 246, 242)));
		colorMap.put(8192, new ColorTuple(new Color(205, 193, 180), new Color(249, 246, 242)));//
	}
	private ColorMap() {
		super();

	}

	public static ColorMap getInstance() {
		return new ColorMap();
	}

	@SuppressWarnings("unused")    //屏蔽unused警告
	static class ColorTuple {
		Color backGroundColor;
		Color textColor;

		public ColorTuple(Color backGroundColor, Color textColor) {
			super();
			this.backGroundColor = backGroundColor;
			this.textColor = textColor;
		}

	}
}
