import java.util.Scanner;
public class MyProgram
{
    public static void main(String[] args)
    {
        //////////
        //SET-UP
        //////////
        
        //Create Scanner
        Scanner input = new Scanner(System.in);
        
        //Ask user to input names for hero and bad guy
        System.out.println("Welcome to BattleItOut!");
        System.out.println();
        System.out.println("Enter your hero's name: ");
        String goodName = input.nextLine();
        System.out.println("Enter your bad guy's name: ");
        String badName = input.nextLine();
        System.out.println();
        
        //Create hero and bad guy, weapons, and scores and print stats
        Weapon weapon = new Weapon("Fiery Deathbringer", "Greatsword", 75, 20);
        Score score = new Score(25);
        Hero hero = new Hero(goodName, weapon, 100, 100, score);
        Weapon badWeapon = new Weapon("The Vaporizer", "Swiftblade", 75, 20);
        Score badScore = new Score(25);
        BadGuy baddy = new BadGuy(badName, badWeapon, 100, 100, badScore);
        System.out.println(hero);
        System.out.println(baddy);
        System.out.println();
        
        //////////
        //MAIN WHILE
        //////////
        
        //Have them automatically enter battles while hero hit points is greater than zero
        int hitPts = hero.getHitPoints();
        int badHitPts = baddy.getHitPoints();
        int counter = 0;
        while (hitPts > 0)
        {
            
            //if the bad guy's hit points reach 0, end the loop
            if (badHitPts <= 0)
            {
                System.out.println("You beat " + badName + "! You won!");
                break;
            }
            
            //////////
            //MINI-GAME
            //////////
            
            //the first time the hero's health is below 20, 
            //allow the user to play a game to win back health
            //Use a counter to ensure the game can only be played once
            if (hitPts <= 20 && counter == 0)
            {
                System.out.println();
                System.out.println(goodName + " only has " + hitPts + " hit points left!");
                System.out.println("You can play this game once to earn more points!");
                System.out.println();
                
                //set question and answer based on loop iteration
                int points = 0;
                for (int q = 1; q <= 5; q++)
                {
                    String question = "";
                    String right = "";
                    if (q == 1)
                    {
                        question += "How many dice are there in DnD? (between 1-10)";
                        right += "7";
                    }
                    else if (q == 2)
                    {
                        question += "What do you call a group of crows?";
                        right += "murder";
                    }
                    else if (q == 3)
                    {
                        question += "What is the name of the hero in the Legend of Zelda series?";
                        right += "Link"; //I swear if anybody puts Zelda
                    }
                    else if (q == 4)
                    {
                        question += "How many of the 137 islands in Hawaii are inhabited?";
                        right += "7"; //It's true I looked it up
                    }
                    else
                    {
                        question += "What author has written over 16 book series in various genres?";
                        right += "Brandon Sanderson";
                    }
                    
                    //use Question class to ask user, compare answer, and add points
                    Question newQuestion = new Question(question, right, 1);
                    System.out.println(question);
                    String answer = input.nextLine();
                    if (answer.equals(right))
                    {
                        points += newQuestion.getPoints();
                    }
                }
                
                //calculate health gained based on score
                if (points > 3)
                {
                    hitPts += 20;
                    hero.setHitPoints(hitPts);
                }
                else if (points > 1)
                {
                    hitPts += 10;
                    hero.setHitPoints(hitPts);
                }
                else
                {
                    hitPts += 5;
                    hero.setHitPoints(hitPts);
                }
                
                //add to counter and print new hit points
                counter ++;
                System.out.println();
                System.out.println(goodName + " now has " + hero.getHitPoints() + "!");
                System.out.println();
            }
            
            //////////////
            //IT'S BATTLE TIME
            //////////////
            
            //print current hit points
            System.out.println(goodName + " has " + hitPts + " hit points.");
            System.out.println(badName + " has " + badHitPts + " hit points.");
            System.out.println();
            System.out.print("Press enter to continue");
            input.nextLine();
            System.out.println();
            System.out.println("Time for a battle!");
            System.out.println();
            
            //do a countdown before each battle begins
            for (int i = 5; i > 0; i--)
            {
                System.out.println(i + "...");
            }
            
            //have each person "roll" to determine who hits
            
            int heroRoll = Dice.roll();
            int badRoll = Dice.roll();
            System.out.println(goodName + " rolled " + heroRoll);
            System.out.println(badName + " rolled " + badRoll);
            
            //if for the hero being stronger and calculate damage done
            int durab = weapon.getDurability();
            int badDurab = badWeapon.getDurability();
            if (heroRoll > badRoll)
            {
                badHitPts -= weapon.getBaseDamage();
                weapon.setDurability(durab - heroRoll);
                if (weapon.getDurability() <= 0)
                {
                    System.out.println(goodName + "'s weapon broke! You're doomed now!");
                    break;
                }
                System.out.println(goodName + " hits! " + badName + " is wounded!");
            }
            
            //else if enemy is stronger, calculate damage done
            else if (badRoll > heroRoll)
            {
                hitPts -= badWeapon.getBaseDamage();
                badWeapon.setDurability(badDurab - badRoll);
                if (badWeapon.getDurability() <= 0)
                {
                    System.out.println(badName + "'s weapon broke!");
                    System.out.println(goodName + " finishes him off in a single blow!");
                    break;
                }
                System.out.println(badName + " catches " + goodName + " off-guard! He is hurt!");
            }
            
            //if they somehow roll equal, have them BOTH do damage
            else
            {
                badHitPts -= weapon.getBaseDamage();
                weapon.setDurability(durab - heroRoll);
                hitPts -= badWeapon.getBaseDamage();
                badWeapon.setDurability(badDurab - badRoll);
                System.out.println("They both hit each other at the same moment!");
            }
        }
        
        //print statement if the user loses
        if (hitPts == 0 || weapon.getDurability() <= 0)
        {
             System.out.println(badName + " killed " + goodName + "! You lose! >:)");
        }
    }
}