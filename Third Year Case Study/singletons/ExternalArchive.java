package singletons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import externalDataClasses.Article;
import externalDataClasses.News;
import helperClasses.ExternalData;
import helperClasses.InternalData;

/*
	The singleton is initialised when getInstance()
	is called. It will return either the old InternalArchive
	object or a new one - if it does not exist.
*/
public class ExternalArchive {
	private static ExternalArchive externalArchive;
	private static ArrayList<News> newsData = new ArrayList<>();
	private static ArrayList<Article> articleData = new ArrayList<>();
	
	private ExternalArchive() {}
	
	
	// Display the data from an array list
	public static void showData(boolean isNews) {
		int i = 1;
		// Display News array
		if(isNews) {
			// Check if empty
			if(newsData.isEmpty()) {
				System.out.println("No News available.\n");
			}
			else {
				for(News element: newsData) {
					System.out.println("Index: "+i+ "\n");
					element.show();
					System.out.println("========================================================================================\n\n");
					i++;
				}
			}	
		}
		// Display Article array
		else {
			// Check if empty
			if(articleData.isEmpty()) {
				System.out.println("No Articles available.\n");
			}
			else {
				for(Article element: articleData) {
					System.out.println("Index: "+i+ "\n");
					element.show();
					System.out.println("========================================================================================\n\n");
					i++;
				}
			}
		}
	}
	
	// Add News to News ArrayList
	public void addNewsData(News newsElement) {
		// Check if input is valid
		if(newsElement.getTitle().matches("") || newsElement.getBody().matches("")) {
			System.out.println("Invalid input.\n");
		}
		else {
			newsData.add(newsElement);
			System.out.println("News data has been added!\n");
		}	
	}
	
	// Add Article to Article ArrayList
	public void addArticleData(Article articleElement) {
		// Check if input is valid
		if(articleElement.getBody().matches("") || articleElement.getIntro().matches("") || articleElement.getTitle().matches("")) {
			System.out.println("Invalid input.\n");
		}
		else {
			articleData.add(articleElement);
			System.out.println("Article data has been added!\n");
		}
		
	}
	
	// Remove either News or Article from their ArrayList
	public void removeData(int index, boolean isNews) {
		if(isNews) {
			// Check if index is valid and if there is a news
			if(!newsData.isEmpty() && index <= newsData.size() && index > 0) {
				newsData.remove(index - 1);
				System.out.println("News removed!\n");
			}
			else {
				System.out.println("No data to remove.\n");
			}
		} else {
			// Check if index is valid and if there is an article
			if(!articleData.isEmpty() && index <= articleData.size() && index > 0) {
				articleData.remove(index - 1);
				System.out.println("Article removed!\n");
			}
			else {
				System.out.println("No data to remove.\n");
			}
		}
	}
	
	// Edit News data in the ArrayList
	public void editNewsData(int index, News newsElement) {
		// Check if index is valid and if there is a news
		if(!newsData.isEmpty() && index <= newsData.size() && index > 0) {
			if(newsElement.getTitle().matches("") || newsElement.getBody().matches("")) {
				System.out.println("Invalid input.\n");
			}
			else {
				newsData.set(index - 1, newsElement);
				System.out.println("News data has been edited!\n");
			}
			
		}
		else {
			System.out.println("No data to remove.\n");
		}
		
	}
	
	// Edit Article data in the ArrayList
	public void editArticleData(int index, Article articleElement) {
		// Check if index is valid and if there is an article
		if(!articleData.isEmpty() && index <= articleData.size() && index > 0) {
			// Check if input is valid
			if(articleElement.getBody().matches("") || articleElement.getIntro().matches("") || articleElement.getTitle().matches("")) {
				System.out.println("Invalid input.\n");
			}
			else {
				articleData.set(index - 1, articleElement);
				System.out.println("Article data has been edited!\n");
			}
		}
		else {
			System.out.println("No data to remove.\n");
		}
	}
	
	
	// Load data into the news and article ArrayLists
	private static void loadFiles(String newsFile, String articleFile) {
		File fileNews = new File(newsFile);
		File fileArticles = new File(articleFile);
		
		try {
			ObjectInputStream iosNews = new ObjectInputStream(new FileInputStream(fileNews));
			ObjectInputStream iosArticle = new ObjectInputStream(new FileInputStream(fileArticles));
			
			try {
				newsData = (ArrayList) iosNews.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				articleData = (ArrayList) iosArticle.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			iosNews.close();
			iosArticle.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	synchronized public static ExternalArchive getInstance() {
		if(externalArchive == null) {
			externalArchive = new ExternalArchive();
			// Load News and Article data
			loadFiles("/Users/nick/Desktop/Data/External Data/News.ser", "/Users/nick/Desktop/Data/External Data/Articles.ser");
		}
		return externalArchive;
	}
}
