package com.nagarro.service;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.dao.Tshirtdao;
import com.nagarro.dto.Tshirt;
import com.nagarro.path.FilePath;
import com.opencsv.CSVReader;

@Service
@Transactional
public class TshirtService {
	@Autowired
	Tshirtdao tdao;
	private volatile boolean stopRequested=false;
	private Thread fileLoaderThread;
	public void readCSV() {
		//to access all csv files present in folder
		File [] files = new File(FilePath.FolderPath).listFiles();
		try {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile() && files[i].getName().endsWith(".csv")) {
					CSVReader reader = new CSVReader(new FileReader(files[i])); // to read files
					String[] nextline;
					nextline = reader.readNext(); // to skip the header details for records
					while ((nextline = reader.readNext()) != null) {
						if ((nextline != null)) {
							String s = Arrays.toString(nextline);
							Tshirt temp = tdao.readInput(s); // to split data into strings
							tdao.storeData(temp);
						}
					}
					reader.close();
				}
				if(stopRequested) {
					break;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void startCsvPollingThread() {
		Runnable rn =  new Runnable() {

			public void run() {
				while (!stopRequested) {
					try {
						Thread.sleep(40000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					readCSV();
				}
			}
		};
		fileLoaderThread = new Thread(rn);
		fileLoaderThread.start();

	}
	public void stopCsvPollingThread() {
		stopRequested = true;
		try {
			fileLoaderThread.join();
		} catch (InterruptedException e) {
			// handle the exception as needed
		}
	}
	
	@PreDestroy
	public void cleanup() {
	    stopCsvPollingThread();
	}
	public List<Tshirt> checkProduct(String color,String size,String gender,String pref) {
		List<Tshirt> t=tdao.fetchData(color,size,gender,pref);
		return t;
	}
}
