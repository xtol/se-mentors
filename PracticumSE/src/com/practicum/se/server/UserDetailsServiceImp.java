package com.practicum.se.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicum.se.client.UserDetailsService;

public class UserDetailsServiceImp extends DataSourceRemoteServiceServlet implements
		UserDetailsService {

	private static final long serialVersionUID = 2426708914426945943L;
	private ResultSet rs;
	private String ss;

	@Override
	public String getUsername(String email) {
		try {
			rs = createStatement().executeQuery("select username from reg_page2 where email='"
					+ email + "'");

			if (rs.next()) {
				ss = rs.getString(1);
			}

		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public String getDob(String email) {

		try {
			rs = createStatement().executeQuery("select date,month,year from reg_page2 where email='"
					+ email + "'");

			if (rs.next()) {
				ss = rs.getString(1) + "-" + rs.getString(2) + "-"
						+ rs.getString(3);

			}

		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public String getCity(String email) {

		try {
			rs = createStatement().executeQuery("select city from reg_page2 where email='"
					+ email + "'");

			if (rs.next()) {

				ss = rs.getString(1);

			}

		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public String getCountry(String email) {

		try {
			rs = createStatement().executeQuery("select country from reg_page2 where email='"
					+ email + "'");

			if (rs.next()) {
				ss = rs.getString(1);

			}

		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public String getAddress(String email) {

		try {
			rs = createStatement().executeQuery("select address from reg_page2 where email='"
					+ email + "'");

			if (rs.next()) {

				ss = rs.getString(1);

			}

		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public String getPhone(String email) {

		try {
			rs = createStatement().executeQuery("select ph_no from reg_page2 where email='"
					+ email + "'");

			if (rs.next()) {
				ss = rs.getString(1);

			}

		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public String getPincode(String email) {

		try {
			rs = createStatement().executeQuery("select pincode from reg_page2 where email='"
					+ email + "'");

			if (rs.next()) {

				ss = rs.getString(1);

			}

		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public String getFname(String email) {

		try {
			rs = createStatement().executeQuery("select firstname from reg_page where email='"
					+ email + "'");

			if (rs.next()) {

				ss = rs.getString(1);

			}

		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public String getMname(String email) {
		try {
			rs = createStatement().executeQuery("select middlename from reg_page where email='"
					+ email + "'");
			if (rs.next()) {

				ss = rs.getString(1);
			}
		} catch (SQLException e) {
		}
		return ss;
	}

	@Override
	public String getLname(String email) {

		try {
			rs = createStatement().executeQuery("select lastname from reg_page where email='"
					+ email + "'");

			if (rs.next()) {

				ss = rs.getString(1);

			}

		} catch (SQLException e) {

		}

		return ss;
	}

	@Override
	public boolean getPUsername(String email) {
		try {
			rs = createStatement().executeQuery("select username from permission where email='"
					+ email + "'");

			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}

		} catch (SQLException e) {
		}

		return false;
	}

	@Override
	public boolean getPDob(String email) {
		try {
			rs = createStatement().executeQuery("select date from permission where email='"
					+ email + "'");

			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}

		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public boolean getPCity(String email) {
		try {
			rs = createStatement().executeQuery("select city from permission where email='"
					+ email + "'");

			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}

		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public boolean getPCountry(String email) {
		try {
			rs = createStatement().executeQuery("select country from permission where email='"
					+ email + "'");
			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public boolean getPAddress(String email) {
		try {
			rs = createStatement().executeQuery("select address from permission where email='"
					+ email + "'");
			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public boolean getPPhone(String email) {
		try {
			rs = createStatement().executeQuery("select ph_no from permission where email='"
					+ email + "'");

			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}

		} catch (SQLException e) {
		}
		return false;

	}

	@Override
	public boolean getPPincode(String email) {
		try {
			rs = createStatement().executeQuery("select pincode from permission where email='"
					+ email + "'");
			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public boolean getPFname(String email) {
		try {
			rs = createStatement().executeQuery("select firstName from permission where email='"
					+ email + "'");
			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public boolean getPMname(String email) {
		try {
			rs = createStatement().executeQuery("select middleName from permission where email='"
					+ email + "'");
			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public boolean getPLname(String email) {
		try {
			rs = createStatement().executeQuery("select lastname from permission where email='"
					+ email + "'");
			if (rs.next()) {
				if (rs.getString(1).equals("1")) {
					return true;
				}
			}
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public String updateuser(String firstName, String middleName,
			String lastName, String email) {
		boolean ss;
		String ss1 = "no";
		try {
			ss = createStatement().execute("update reg_page set firstName='" + firstName
					+ "',middleName='" + middleName + "',lastname='" + lastName
					+ "' where email='" + email + "'");

			if (!ss) {
				ss1 = "yes";
			}
		} catch (SQLException e) {
		}
		return ss1;
	}

	@Override
	public String updateuser1(String emai, String username, String country,
			String city, String pincode, String address, String ph_no,
			String date, String month, String year) {
		boolean ss;
		String ss1 = "no";
		try {
			ss = createStatement().execute("update reg_page2 set username='" + username
					+ "',country='" + country + "',city='" + city
					+ "',pincode='" + pincode + "',address='" + address
					+ "',ph_no='" + ph_no + "' where email='" + emai + "'");

			if (!ss) {
				ss1 = "yes";
			}
		} catch (SQLException e) {
		}
		return ss1;
	}

	@Override
	public String updatepermission(String email, int firstName, int middleName,
			int lastname, int username, int country, int city, int pincode,
			int address, int ph_no, int dob) {
		boolean ss;
		String ss1 = "no";
		try {
			ss = createStatement().execute("update permission set firstName='" + firstName
					+ "',middleName='" + middleName + "'," + "lastname='"
					+ lastname + "',username='" + username + "',country='"
					+ country + "'," + "city='" + city + "',pincode='"
					+ pincode + "',address='" + address + "',ph_no='" + ph_no
					+ "' where email='" + email + "'");
			if (!ss) {
				ss1 = "yes";
			}
		} catch (SQLException e) {
		}
		return ss1;
	}

}
