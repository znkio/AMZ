package com.io.znk.ctalin.web.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Controller
@RequestMapping(value = "/mobile/utils")
public class UtilsController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getachs(HttpServletRequest request) throws IOException {
        String qstring = request.getQueryString();
        String myCodeText = URLDecoder.decode(qstring,"UTF-8");
        String filePath = "C:\\Users\\gmotux\\Desktop\\3rd\\zenika_rouf\\QR.png";
        int size = 300;
        String fileType = "png";
        File myFile = new File(filePath);
        try {
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
            int CrunchifyWidth = byteMatrix.getWidth();
            BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
                    BufferedImage.TYPE_INT_RGB);
            image.createGraphics();

            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < CrunchifyWidth; i++) {
                for (int j = 0; j < CrunchifyWidth; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, fileType, myFile);
            byte[] by = IOUtils.toByteArray(new FileInputStream(myFile));
            MultiValueMap<String, String> headers = new LinkedMultiValueMap();
            List<String> val = new ArrayList();
            val.add("image/png");
            headers.put("Content-Type", val);
            ResponseEntity<byte[]> ret = new ResponseEntity(by, headers, HttpStatus.OK);
            return ret;
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\nYou have successfully created QR Code.");
        return null;
    }

}
