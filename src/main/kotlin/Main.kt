// This object will be used for the reader to take input other than string for the user.
import java.util.*

/*************************************************************************
 * ====== ACCOUNT CLASS =====
 * The account class will take care of everything to do the accounts.
 ************************************************************************/
class Account
{
    // These will be used to set up the account
    private var name: String = ""
    private var accountID: Int = 0
    private var accountBalance: Double = 0.0

    // This will set the account name to be accessible
    fun setAccountName(name: String)
    {
        this.name = name
    }

    // This will set the account ID to be accessible
    fun setAccountID(accountID: Int)
    {
        this.accountID = accountID
    }

    // This will set the account balance to be accessible
    fun setAccountBalance(accountBalance: Double)
    {
        this.accountBalance = accountBalance
    }

    // This will display the account balance
    fun getAccountDetails(): String
    {
        return "Name: $name, Account ID: $accountID AccountBalance: $$accountBalance"
    }
}

// The main loop program
// This is where all the logic happens
fun main(args: Array<String>)
{
    // Initializes the Account class
    val account = Account()
    // Initializes the scanner to read input other than strings
    val scanner = Scanner(System.`in`)

    var endProgram = false

    // This loop allows us to do things as long as endProgram is false
    while (!endProgram)
    {
        var mainMenuPick : Int?
        // The main menu display
        val mainMenu =
            """===== Welcome to the main menu =====
            Please chose an option:
            1) Budget menu
            0) Exit Program
            """.trimIndent()
        println(mainMenu)
        mainMenuPick = readlnOrNull()?.toIntOrNull()

        // If not 1 or 0, pick again!
        while (mainMenuPick !in 0..1 || mainMenuPick == null)
        {
            println("Please chose a valid option: ")
            mainMenuPick = readlnOrNull()?.toIntOrNull()
        }
        // Sends the user to their choice
        when(mainMenuPick)
        {
            1 ->
                {
                    // Gets the account name from the user
                    println("What is the name on the account: ")
                    val accountName = readlnOrNull()

                    // Gets the account ID from the user
                    println("What would you like for the account ID: ")
                    val accountID = scanner.nextInt()

                    // Gets the account balance from the user
                    println("What is the account balance: ")
                    var accountBalance = scanner.nextDouble()

                    // Sets all the account information and displays it
                    if (accountName != null) { account.setAccountName(accountName) }
                    account.setAccountID(accountID)
                    account.setAccountBalance(accountBalance)
                    println(account.getAccountDetails())

                    val editBudget = true

                    var edit : Boolean = true

                    println("Would you like to add or subtract from the account? (type yes, or no): ")
                    val choiceEdit = readlnOrNull()
                    if (choiceEdit != null && choiceEdit.lowercase() == "yes")
                    {
                        // Loops through as long until the user quits
                        while (edit)
                        {
                            println("To add, type add, and to subtract, type subtract (type q to go back)")

                            print(": ")
                            val choice = readlnOrNull()
                            if (choice != null)
                            {
                                // Adds to the account balance
                                if (choice.lowercase(Locale.getDefault()) == "add")
                                {
                                    println("How much would you like to add: ")
                                    val addedAmount = scanner.nextDouble()
                                    //edit = false

                                    accountBalance += addedAmount
                                    println("Your new balance is : $$accountBalance")
                                }
                                // Subtracts from the account balance
                                else if (choice.lowercase(Locale.getDefault()) == "subtract")
                                {
                                    println("How much would you like to subtract: ")
                                    val subtractAmount = scanner.nextDouble()

                                    accountBalance -= subtractAmount
                                    println("Your new balance is : $$accountBalance")
                                    //edit = false
                                }
                                // Quits the eddit loop
                                else if (choice.lowercase() == "q")
                                {
                                    edit = false
                                }
                            }
                        }
                    }
                    // Returns to the main menu
                    else if (choiceEdit != null && choiceEdit.lowercase() == "no")
                    {
                        println(mainMenu)
                    }
                }
            // Quits the program
            0 -> { endProgram = true }
        }
    }
}