package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.DAO.FlightDAO;
import com.DAO.FlightDaoImpl;
import com.dto.Flight;

import net.bytebuddy.description.type.TypeList.Generic;

/**
 * Servlet implementation class FlightList
 */
public class FlightList extends HttpServlet 
{
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String src = request.getParameter("source_country");
		String dest = request.getParameter("destination_country");
		String date = request.getParameter("book_date");
		int pass = Integer.parseInt(request.getParameter("n_pass"));
		
		PrintWriter out = response.getWriter();
		FlightDAO flightDAO = new FlightDaoImpl();
		
		try
		{	
			List<Flight> res = flightDAO.listFlights(src, dest, date, pass);
			request.setAttribute("flightList", res);
		}
		catch(Exception e)
		{
			System.out.println("\n\nStack Trace:");
			e.printStackTrace();
			System.out.println("\n\nMessage:"+e.getMessage());
			System.out.println("\n\nThere are no flights matching your search criterion.");
		}
		finally
		{
			
			request.getRequestDispatcher("flightbook.jsp").forward(request,response);
			out.close();
		}
		
		}
		
		
	}


