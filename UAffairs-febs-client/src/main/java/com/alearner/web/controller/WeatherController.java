package com.alearner.web.controller;

import com.alearner.common.annotation.Log;
import com.alearner.common.controller.BaseController;
import com.alearner.common.domain.ResponseBo;
import com.alearner.common.util.HttpUtils;
import com.alearner.common.util.UrlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WeatherController extends BaseController {

	@Log("获取天气信息")
	@RequestMapping("weather")
	public String weather() {
		return "web/weather/weather";
	}

	@RequestMapping("weather/query")
	@ResponseBody
	public ResponseBo queryWeather(String areaId) {
		try {
			String data = HttpUtils.sendPost(UrlUtils.MEIZU_WEATHER_URL, "cityIds=" + areaId);
			return ResponseBo.ok(data);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBo.error("查询天气失败，请联系网站管理员！");
		}
	}
}
