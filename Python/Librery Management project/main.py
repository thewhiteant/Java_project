
from tinydb import TinyDB, Query
import os


class ok:
    pass




bookDB = TinyDB('Books.json',indent=4)
MemberDB = TinyDB('Members.json',indent=4)
q = Query()




        


# system controlc

def have_Mem_books(phn):
       bk = MemberDB.search(q.phone == phn)
       if(bk):
        return bk[0]['haveB']


def have_member(member,phn):
    mem = MemberDB.search(q.name == member)
    ph = MemberDB.search(q.phone == phn)
    if(mem and ph):
       return True
    else:
        return False


def have_books(name):
    bk = bookDB.search(q.name == name)
    if(bk):
        return True
    else:
        return False

def how_many_book(num):
     bcou = MemberDB.search(q.phone == num)
     if(bcou):
        return bcou[0]['total']

def book_qntt(book):
    bk = bookDB.search(q.name == book)
    if(bk):
        return bk[0]['qntt']

# books control
def addBook_option():

    

    bname = input("Book-Name: ")
    AuthName = input("Author-Name: ")
    rprice = input("Reguler-Price: ")
    btype = input("Book Type: ")
    qntt = input("Book Quantities: ")
    os.system("cls")
    add_book(bname, AuthName, rprice, btype,qntt)


def add_book(name, auth, price, type,qq):
    book = bookDB.search(q.name == name)
    if(not book):
        bookDB.insert({"name":name,"auth":auth,"price":price,"type":type,"qntt":int(qq)})

    else:
        print("Already Ase")



def remove_book(name,vaxCrypt):
    book = bookDB.search(q.name == name)
    if(book and vaxCrypt=="12345"):
        bookDB.remove(q.name==name)


def show_all_book():
    all_data = bookDB.all()

    for i in range(len(all_data)):
        print(f"{i+1}. {all_data[i]['name']} -->price: {all_data[i]['price']} --->Qn: {all_data[i]['qntt']} ")
    print("\n\n\n\n\n\n")


def get_book_qntt(name):
    book = bookDB.search(q.name == name)
    print(f"{name} has {book[0]['qntt']} Pices")
    print("\n\n\n\n\n\n")

def Book_section():
    while True:
         print("1.All books properties \n2.Add Books\n3.Remove Book\n4.Book QunTT\n5.Back\nChose: ",end="")
         en = int(input())
         if(en == 1):
            os.system("cls")
            show_all_book()
         elif(en == 2):
            os.system("cls")
            asp = int(input("How many: "))
            for i in range(asp):    
                addBook_option()
         elif(en==3):
            os.system("cls")
            rb = input("Book-Name: ")
            remove_book(rb, "12345")
         elif(en==4):
            os.system("cls")
            rb = input("Book-Name: ")
            get_book_qntt(rb)

         else:
            os.system("cls")
            break;
           




# member control


def mem_section():
    while True:
         print("1.All Members \n2.Add Members\n3.Remove Members\n4.Back\nChose: ",end="")
         en = int(input())
         if(en == 1):
            os.system("cls")
            show_all_mem()
         elif(en == 2):
            os.system("cls")
            asp = int(input("How many: "))
            for i in range(asp):    
                add_member()
         elif(en==3):
            os.system("cls")
            rb = input("Book-Name: ")
            remove_member(rb, "12345")

         else:
            os.system("cls")
            break;
           
       

def add_member():
    name = input("Name: ")
    add = input("Address: ")
    while True:
        phone = input("phone number :+880 ")
        if len(phone) == 10:
             break
    bq = input("Have any book: ")
    os.system("cls")
    add_mem_db(name, add, phone, bq)


def add_mem_db(name,add,phn,hB):
    mem = MemberDB.search(q.name == name)
    if(not mem):
        MemberDB.insert({"name":name,"address":add,"phone":phn,"haveB":hB,"total":0,"fav":"none"})



def remove_member(name,vaxCrypt):
    mem = MemberDB.search(q.name == name)
    if(mem and vaxCrypt=="12345"):
        MemberDB.remove(q.name==name)



def show_all_mem():
    all_data = MemberDB.all()

    for i in range(len(all_data)):
        print(f"{i+1}. {all_data[i]['name']} -->Book Have: {all_data[i]['haveB']} --->Qn: {all_data[i]['fav']} ")

    print("\n\n\n\n\n\n")



#rental system

def rental_option():
    while True:
        print("1.Rent \n2.Back\nChose: ",end="")
        rnt = int(input())
        if(rnt == 1):
            os.system("cls")
            rent()
        elif(rnt == 2):
                os.system("cls")
                back()

        elif(rnt==3):
                os.system("cls")
        else:
            os.system("cls")
            break;


def rent():
    os.system("cls")
    print("Rental System")
    name = input("Name: ")
    phn = input("Phone: +880")
    bko = input("Book: ")
    # os.system("cls")
    rent_Sys(name,phn,bko)


def back():
    os.system("cls")
    print("Return Book")
    name = input("Name: ")
    phn = input("Phone: +880")
    bko = input("Book: ")
    # os.system("cls")
    back_SYS(name,phn,bko)



def rent_Sys(nam,phn,book):
    if(have_member(nam,phn) and have_books(book)):
        if(book_qntt(book)>0):
            bookDB.update({'qntt':book_qntt(book)-1},q.name==book)
            MemberDB.update({'haveB':book,'total':(have_books(phn)+1)},q.name == nam)    
        else:
            print("Book Count Problem")



def back_SYS(nam,phn,book):
    if(have_member(nam,phn) and have_books(book) and have_Mem_books(phn) == book):
            bookDB.update({'qntt':book_qntt(book)+1},q.name==book)
            MemberDB.update({'haveB':None},q.name == nam) 
    else:
        print("Back Problem");   



def who_hve_theBOok(book):
    pass





def main(data):
    while (True):

        print("Librery Management Project\n1.Book Section\n2.Member Section\n3.Rental System\nChosse:",
              end="")
        n = int(input())
        if(n == 1):
            os.system("cls")
            Book_section()
        elif(n == 2):
            os.system("cls")
            mem_section()
        elif(n == 3):
            os.system("cls")
            rental_option()
            
        else:
            os.system("cls")
            break;
            
        

if __name__ == '__main__':
    data = ""
    os.system("cls")
    main(data)


