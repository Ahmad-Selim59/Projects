import string

#function that stores the text in a list
def store_text_in_list(my_file):
    str1 = ''
    list1 = []
    str2 = '<N'

    for i in my_file:
        if str2 not in i:
            i = i.lower()
            str1 = str1 + ''.join(i.rstrip("\n")) + ' '
            continue
        else:
            if str1 == '':
                continue
            else:

                for i in str1:
                    if i in string.punctuation:
                        str1.replace(i, '')
                list1.append(str1)
                str1 = ''
                continue 
    list1.append(str1)
    return list1


#function that stores the words as keys in a dictionary 
def store_text_in_dict(list1):
    j = 0
    i = 0
    index = 0
    dict1 = {}
    
    #splitting the list so that every word is stored as an individual element
    word = list1[i].split()
    for word[j] in word:
        if i < len(list1):
            word = list1[i].split()

        else:
            break
        #storing the words in the dict
        while index < len(word):
            if word[j] in dict1:
                dict1[word[j]] = dict1[word[j]]  + [i + 1]
                j += 1
                index += 1
            else:
                dict1[word[j]] = [i + 1]
                j += 1
                index += 1
        else:
            i += 1
            j = 0
            index = 0
    return dict1


#function that lets you search for words
def search_for_word(dict1, word1, word2):
    set1 = set()
    set2 = set()
    index = 0
    common_set = set()

    for index in dict1.keys():
        if index == word1:
            print(index, "-", dict1[index])
            set1 = set(dict1[index])
        elif index == word2:
            print(index, "-", dict1[index])
            set2 = set(dict1[index])
        else:
            continue
    common_set = set1 & set2
    print("both words appear in doc ", common_set)

#printing out a document
def output_doc(list1, i):
    i = i -1
    print(list1[i])

my_file = open('ap_docs.txt', 'r')
list1 = store_text_in_list(my_file)
dict1 = store_text_in_dict(list1)
document_number = 0
user_input = 0

exit = 'n'
while exit == 'n':
    while user_input != 1 and user_input != 2 and user_input != 3:
        print("what would you like to do")
        print("1. Search for documents")
        print("2. Read Document")
        print("3. Quit Program")

        user_input = int(input("enter the number before the option you want to pick: "))

    if user_input == 1:
        word1, word2 = input("enter 2 words you wish to search for: ").split()
        search_for_word(dict1, word1, word2)
        user_input = 0

    elif user_input == 2:
        document_number = int(input("enter a document number that you would like to read: "))
        output_doc(list1, document_number)
        user_input = 0

    elif user_input == 3:
        exit = 'y'


my_file.close()
