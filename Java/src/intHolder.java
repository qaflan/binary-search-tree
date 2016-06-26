/**
 * Ulu Tanrýnýn Adi il?
 * Created by IntelliJ IDEA.
 * User: Javad Nouri
 * Date: Jun 10, 2007
 * Time: 1:12:05 PM
 * E-mail: javad.xp@gmail.com
 */

//This class is used to make an integer of type reference
    //for example you can't create a vector of a primitive type
public class intHolder {
    public int value;   //The carried value
        intHolder(){    //Default constructor
            value=0;    //initialize value to 0
        };
        intHolder(int v){//Constructor
            value=v;    //initialize value
        }
        public String toString(){   //Override the method toString
            return Integer.toString(value);
        }
        public int Addpp(){         //Simulates the post increment operation
            value++;
            return value-1;
        }

}
