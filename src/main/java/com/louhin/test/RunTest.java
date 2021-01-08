package com.louhin.test;

import java.io.File;

import fi.datarangers.dmtools.common.GeneralException;
import fi.datarangers.dmtools.data.Data;
import fi.datarangers.dmtools.data.io.CsvIO;

public class RunTest {

	public static void main(String[] args) throws GeneralException {
		File in1 = new File("in/in1.csv");
		File out1 = new File("out/out1.csv");
		Data in = CsvIO.loadCsvData(in1);
		Data out = in.clone();
		CsvIO.saveTextData(out, out1);
		System.out.println("done");
	}

}
