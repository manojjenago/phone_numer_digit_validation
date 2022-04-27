## Phone Number Digit check

Handle phone number check based on the digit. 

##Features:
- Check if the valid_word matched with the digit
- Check if there are any duplicate
- Able to check if there are upper case
- Added validation for the input param
- Unit testing for every functionality & negative test case

##Complexity:
### time complexity: O(N * M)
N -> total size of valid words
M -> maximum length of the valid word
Time complexity is because of the loop for every single words O(N) and check every single letter inside the word O(M)

### space complexity O(N)
Adding new hashset to handle duplicate words

## How to run
- Clone the repo
- Check testFile TestPhoneNumberCheck
- Check testGetMatchingWords and modified it to test the functionality