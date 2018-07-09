package com.javaapi.test.test.dataStructure.transfer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Client {

	/**
	 * 数组转list
	 */
	@Test
	public void arrayToList() throws Exception {
		String [] str = {"a","b"};
		//
		List<String> asList = Arrays.asList(str);
		//
		System.err.println(asList);
	}
	/**
	 * list转数组
	 */
	@Test
	public void listToArray() throws Exception {
		List<String> asList  = new ArrayList<>();
		asList.add("a");
		asList.add("b");
		//
		String[] array = asList.toArray(new String[asList.size()]);
		//
		for (String string : array) {
			System.err.println(string);
		}
	}
	/**
	 * map得value转list
	 */
	@Test
	public void mapValueToCollection() throws Exception {
		Map<String,String> map = new HashMap<>();
		map.put("a", "b");
		map.put("c", "b");
		ArrayList<String> arrayList = new ArrayList<>( map.values());
		System.err.println(arrayList);
	}
	/**
	 * map得key转list,key无序
	 */
	@Test
	public void mapKeyToCollection() throws Exception {
		Map<String,String> map = new HashMap<>();
		map.put("a", "b");
		map.put("c", "b");
		ArrayList<String> arrayList = new ArrayList<>(map.keySet());
		System.err.println(arrayList);
	}
    @Test  
    public void convert_list_to_map_with_guava () {  
        List<Movie> movies = Lists.newArrayList();  
        movies.add(new Movie(1, "The Shawshank Redemption"));  
        movies.add(new Movie(2, "The Godfather"));
        movies.add(new Movie(3, "The Godfather22"));  
        Map<Integer,Movie> mappedMovies = Maps.uniqueIndex(movies, new Function <Movie,Integer> () {  
              public Integer apply(Movie from) {  
                return from.getRank();   
        }});  
        System.err.println(mappedMovies);
        assertTrue(mappedMovies.size() == movies.size());  
        assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());  
    }  
    @Test  
    public void convert_list_to_map_with_guava2 () {  
      
         
        List<Movie> movies = Lists.newArrayList();  
        movies.add(new Movie(1, "The Shawshank Redemption"));  
        movies.add(new Movie(2, "The Godfather"));
        movies.add(new Movie(2, "The Godfather22"));  
        Map<Integer,Movie> mappedMovies = Maps.uniqueIndex(movies, new Function <Movie,Integer> () {  
              public Integer apply(Movie from) {  
                return from.getRank();   
        }});  
        System.err.println(mappedMovies);
        assertTrue(mappedMovies.size() == 2);  
        assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());  
    }  
}
