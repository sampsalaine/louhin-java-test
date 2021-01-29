package com.louhin.test;

import java.awt.image.BufferedImage;
import java.io.File;

import org.jfree.chart.ChartPanel;

import fi.datarangers.dmtools.data.Data;
import fi.datarangers.dmtools.data.io.CsvIO;
import fi.datarangers.dmtools.math.image.ImageUtil;
import fi.datarangers.dmtools.util.ChartUtil;
import fi.datarangers.dmtools.util.DataUtil;
import fi.datarangers.dmtools.util.FileUtil;

public class RunTest {

	public static void main(String[] args) {
		try {
			File in1 = new File("in/in1.csv");
			File out1 = new File("out/out1.csv");
			Data in = CsvIO.loadCsvData(in1);
			Data out = in.clone();
			CsvIO.saveTextData(out, out1);

			int w = 400, h = 300;
			for (int i = 0; i < args.length; i++) {
				if (args[i].trim().equals("-width"))
					w = Integer.parseInt(args[i + 1]);
				else if (args[i].trim().equals("-height"))
					h = Integer.parseInt(args[i + 1]);
			}

			ChartPanel cp = ChartUtil.createBarChart(DataUtil.createRandomData(5, 2), false);
			cp.setSize(w, h);
			BufferedImage bi = cp.getChart().createBufferedImage(w, h);
			byte[] by = ImageUtil.getBytes(bi, "png");
			File fig1 = new File("out/fig1.png");
			FileUtil.saveToFile(by, fig1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
