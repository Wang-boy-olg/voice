package com.springboot_temperaturetest.demo.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.util.Scanner;

/**
 * @ClassName voice
 * @Author asus
 * @Date 2020/7/20 9:14
 * @Version 1.0
 * @Function <功能描述>
 */
public class voice {
    public void speak(String args) {
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        Dispatch sapo = sap.getObject();
        try {
            // 音量 0-100
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(2));
            Scanner scan = new Scanner(System.in);
            String str = "体温过高，请前往医院检查";
            // 执行朗读
            Dispatch.call(sapo, "Speak", new Variant(args));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }

}
