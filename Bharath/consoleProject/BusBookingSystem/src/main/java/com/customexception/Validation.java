package com.customexception;

public class Validation {

		public static int validateOption(String option) throws OptionException {
			if (!option.matches("\\d")) {
				System.out.println(" *"+"*".repeat(22)+"*");
				throw new OptionException(" | Enter a valid Option |"+"\n"+" "+"*".repeat(23)+"*");
			}
			return Integer.parseInt(option);
		}

		public static String validateName(String name) throws NameException {
			if (!name.matches("^[A-Za-z]+(?: [A-Za-z]+)*$")) {//number not given
				System.out.println(" *"+"*".repeat(20)+"*");
				throw new NameException(" | Enter a valid Name |"+"\n"+" "+"*".repeat(21)+"*");
				}
			else if(name.length()<=2) {
				System.out.println(" "+"*".repeat(40)+"*");
				throw new NameException(" |  Name cannot be less than 2 character |"+"\n"+" "+"*".repeat(40)+"*");
				}
			return name;
			}
		public static String validateLastName(String lastName) throws LastNameException {
			if (!lastName.matches("^[A-Za-z]+(?: [A-Za-z]+)*$")) {//number not given
				System.out.println(" *"+"*".repeat(20)+"*");
				throw new LastNameException(" | Enter a valid Name |"+"\n"+" "+"*".repeat(21)+"*");
				}
			return lastName;
			}
	
		public static String validateGender(String gender)throws GenderException{
			if(!gender.equalsIgnoreCase("male")&&(!gender.equalsIgnoreCase("female"))){
				System.out.println(" "+"*".repeat(36)+"*");
				throw new GenderException(" | Gender can be only male or female |" +"\n"+" "+"*".repeat(36)+"*");
				
			}
			return gender;
		}
		public static String validateEmail(String email) throws EmailException {
			if (!email.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,}$")) {
				System.out.println(" "+"*".repeat(38));
				throw new EmailException(" | Please enter a valid email address |"+"\n"+" "+"*".repeat(38));//23Fjnn.dfdf Invalid email
			}
			return email;
		}

		public static String validateUserName(String username) throws UserNameException {
		    if (!username.matches("^[a-zA-Z0-9_-]{7,16}$")) {
		    	System.out.println(" "+"*".repeat(151));
		        throw new UserNameException(" | Please enter a string with only letters (both uppercase and lowercase), digits, underscores, and hyphens, and a length between 7 and 16 characters. |"+"\n"+" "+"*".repeat(151));
		    }
			return username;
		}


		public static String validatePassword(String password) throws PasswordException {
	     	 	if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
	     	 		System.out.println(" "+"*".repeat(92));
	     	 		throw new PasswordException(" | Invalid Password:Minimum 7 character,uppercase,lowercase,digits,underscores and hyphends |"+"\n"+" "+"*".repeat(92));
	     	 	}
	     	 	return password;
	     	}

		public static String validatePhoneno(String Phoneno) throws PhoneNumberException {
	    		 if(!Phoneno.matches("^[6-9]{1}[0-9]{9}$")){
	    			 System.out.println(" "+"*".repeat(91));
	    				 throw new PhoneNumberException(" | Invalid Phone number. Please enter a valid 10-digit number starting with 6, 7, 8, or 9. |"+"\n"+" "+"*".repeat(91));
	    	 }
	    	return Phoneno;
		}
		public static String validateStartLocation(String start) throws StartLocationException {
		    if (start.isEmpty()||start.matches("\\s")||start.equals(null)) {
		    	System.out.println(" +"+"-".repeat(41)+"+");
		        throw new StartLocationException(" | Start location cannot be null or empty. |"+"\n"+" +"+"-".repeat(41)+"+");
		    }
		    else if(!start.matches("[a-zA-Z]+")) {
		    	System.out.println(" +"+"-".repeat(41)+"+");
		    	throw new StartLocationException( " | Start location should be in words only. |"+"\n"+" +"+"-".repeat(41)+"+");
		    }
		    return start;
		}
		public static String validateDestinationLocation(String destination) throws EndLocationException {
		    if (destination.isEmpty()||destination.matches("\\s")||destination.equals(null)) {
		    	System.out.println(" +"+"-".repeat(47)+"+");
		        throw new EndLocationException(" | Destination location cannot be null or empty. |"+"\n"+" +"+"-".repeat(47)+"+");
		    }
		    else if(!destination.matches("[a-zA-Z]+")) {
		    	System.out.println(" +"+"-".repeat(44)+"+");
		    	throw new EndLocationException( " | Destination location should be words only. |"+"\n"+" +"+"-".repeat(44)+"+");
		    }
		    return destination;
		}
		public static String validateDistance(String distance) throws DistanceException {
			 if (distance.isEmpty()||distance.matches("\\s")||distance.equals(null)) {
				 	System.out.println(" +"+"-".repeat(35)+"+");
			        throw new DistanceException(" | Distance cannot be null or empty. |"+"\n"+" +"+"-".repeat(35)+"+");
			    }
			 else if (!distance.matches("^(0*[1-9][0-9]*)$")) {
				System.out.println(" +"+"-".repeat(27)+"+");
                throw new DistanceException(" | Distance should be number |"+"\n"+" +"+"-".repeat(27)+"+");
            }
			return distance;
		}
		public static String validateDuration(String duration) throws DurationException {
			 if (duration.isEmpty()||duration.matches("\\s")||duration.equals(null)) {
				 	System.out.println(" +"+"-".repeat(35)+"+");
			        throw new DurationException(" | Duration cannot be null or empty. |"+"\n"+" +"+"-".repeat(35)+"+");
			    }
			else if (!duration.matches("^(0*[1-9][0-9]*)$")){
				System.out.println(" +"+"-".repeat(27)+"+");
                throw new DurationException(" | Duration should be number |"+"\n +"+"-".repeat(27)+"+");   
            }
			 
			return duration;
		}
		public static String validateCardNumber(String cardNumber) throws CardNumberException {
			if (cardNumber.length() < 13 || cardNumber.length() > 16) {
                throw new CardNumberException("Card number must have between 13 and 16 digits");
            }
			return cardNumber;
		}
		public static int validateSerialNumber(String option) throws SerialNumberException {
			if (!option.matches("^(0*[1-9][0-9]*)$")) {
				throw new SerialNumberException(" Please enter a valid Number");
			}
			return Integer.parseInt(option);
		}
		public static String validateWord(String selectOne) throws WordException {
		    if (selectOne.isEmpty()||selectOne.matches("\\s")||selectOne.equals(null)) {
		    	System.out.println(" +"+"-".repeat(25)+"+");
		        throw new WordException(" | It cannot null or empty.|"+"\n"+" +"+"-".repeat(25)+"+");
		    }
		    else if(!selectOne.matches("[a-zA-Z]+")) {
		    	System.out.println(" +"+"-".repeat(29)+"+");
		    	throw new WordException( " | It should be in words only. |"+"\n"+" +"+"-".repeat(29)+"+");
		    }
		    return selectOne;
		}
		public static String validateNumber(String numerical) throws InvalidNumberException {
			if (!numerical.matches("\\d")) {
				System.out.println(" +"+"-".repeat(20)+"+");
				throw new InvalidNumberException(" | Enter valid Number |"+"\n"+" +"+"-".repeat(20)+"+");
			}
			return numerical;
		}
//		public static void star() {
//			
//		}
	}

