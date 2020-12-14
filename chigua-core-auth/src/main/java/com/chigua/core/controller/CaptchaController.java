package com.chigua.core.controller;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;

/**
 * ProjectName: chigua-core-web
 * ClassName: com.chigua.core.controller.CaptchaController
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 验证码
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/14 - 10:10
 */
@RestController
@Api(value = "验证码管理",tags = "验证码管理")
public class CaptchaController {

    /** *
     * ==========================================
     * 类型
     * =========================================
     *   类型	            描述
     *   TYPE_DEFAULT	    数字和字母混合
     *   TYPE_ONLY_NUMBER	纯数字
     *   TYPE_ONLY_CHAR	    纯字母
     *   TYPE_ONLY_UPPER	纯大写字母
     *   TYPE_ONLY_LOWER	纯小写字母
     *   TYPE_NUM_AND_UPPER	数字和大写字母
     * ==========================================
     * ==========================================
     * 字体
     * ==========================================
     *  Captcha.FONT_1
     *  Captcha.FONT_2
     *  Captcha.FONT_3
     *  Captcha.FONT_4
     *  Captcha.FONT_5
     *  Captcha.FONT_6
     *  Captcha.FONT_7
     *  Captcha.FONT_8
     *  Captcha.FONT_9
     *  Captcha.FONT_10
     * ==========================================
     *
     */
    @ApiOperation(value = "/captcha",tags = "获取验证码")
    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置字体 > 有默认字体，可以不用设置
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        // 验证码存入session
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());
        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }
}
