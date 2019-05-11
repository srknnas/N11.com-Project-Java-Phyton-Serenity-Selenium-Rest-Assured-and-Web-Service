from flask import Flask, jsonify
from flask import make_response
from flask import request
import random
# -*- coding: utf-8 -*-

members = [
    {
		'id': 1000,
        'Name': 'Salih',
        'Surname': 'Akan',
        'mail': 'sakan1234@gmail.com', 
        'password': '12345a78',
		'verifyPassword': '12345a78',
        'phoneNumber':'337985343',
        'gender': 'Male',
		'birthdateDay': 9,
		'birthdateMonth':'Ocak',
		'birthdateYear':1988,
        'status': 'OK'
    },
	{
		'id': 1001,
        'Name': 'Mehmet',
        'Surname': 'Ahmet',
        'mail': 'mahmet1234@gmail.com', 
        'password': '87b54321',
		'verifyPassword': '87b54321',
        'phoneNumber':'324568974',
        'gender': 'Male',
		'birthdateDay': 15,
		'birthdateMonth':'Mart',
		'birthdateYear':1976,
        'status': 'OK'
    },
    {
        'id': 1002,
        'Name': 'Ayse',
        'Surname': 'Fatma',
        'mail': 'afatma1234@gmail.com', 
        'password': '13579c113',
        'verifyPassword': '13579c113',
        'phoneNumber':'367495328',
        'gender': 'Female',
        'birthdateDay': 18,
        'birthdateMonth':'Nisan',
        'birthdateYear':1980,
        'status': 'OK'
    },
    {
        'id': 1003,
        'Name': 'Ali',
        'Surname': 'Turan',
        'mail': 'aturan1234@gmail.com', 
        'password': '4319d5749',
        'verifyPassword': '4319d5749',
        'phoneNumber':'345981548',
        'gender': 'Male',
        'birthdateDay': 7,
        'birthdateMonth':'Haziran',
        'birthdateYear':1982,
        'status': 'OK'
    },
    {
        'id': 1004,
        'Name': 'Merve',
        'Surname': 'Deniz',
        'mail': 'mdeniz1234@gmail.com', 
        'password': 'e8924782',
        'verifyPassword': 'e8924782',
        'phoneNumber':'362481972',
        'gender': 'Female',
        'birthdateDay':27,
        'birthdateMonth':'Temmuz',
        'birthdateYear':1972,
        'status': 'OK'
    },
    {
        'id': 1005,
        'Name': 'Koray',
        'Surname': 'Keskin',
        'mail': 'kkeskin1234@gmail.com', 
        'password': '48652f7534',
        'verifyPassword': '48652f7534',
        'phoneNumber':'328914571',
        'gender': 'Male',
        'birthdateDay':17,
        'birthdateMonth':'Ekim',
        'birthdateYear':1982,
        'status': 'OK'
    },
    {
        'id': 1006,
        'Name': 'Buket',
        'Surname': 'Demir',
        'mail': 'bdemir1234@gmail.com', 
        'password': '3495176g',
        'verifyPassword': '3495176g',
        'phoneNumber':'363541554',
        'gender': 'Female',
        'birthdateDay':21,
        'birthdateMonth':'Ocak',
        'birthdateYear':1987,
        'status': 'OK'
    },
    {
        'id': 1007,
        'Name': 'Cihan',
        'Surname': 'Tutar',
        'mail': 'ctutar1234@gmail.com', 
        'password': 'h2984581',
        'verifyPassword': 'h2984581',
        'phoneNumber':'345793478',
        'gender': 'Male',
        'birthdateDay':27,
        'birthdateMonth':'Mart',
        'birthdateYear':1990,
        'status': 'OK'
    },
    {
        'id': 1008,
        'Name': 'Duygu',
        'Surname': 'Yavuz',
        'mail': 'dyavuz1234@gmail.com', 
        'password': '1k493715',
        'verifyPassword': '1k493715',
        'phoneNumber':'324821432',
        'gender': 'Female',
        'birthdateDay':2,
        'birthdateMonth':'Nisan',
        'birthdateYear':1996,
        'status': 'OK'
    },
    {
        'id': 1009,
        'Name': 'Mert',
        'Surname': 'Sezgin',
        'mail': 'msezgin1234@gmail.com', 
        'password': '81l61385',
        'verifyPassword': '81l61385',
        'phoneNumber':'362971568',
        'gender': 'Male',
        'birthdateDay':13,
        'birthdateMonth':'Haziran',
        'birthdateYear':1965,
        'status': 'OK'
    },
]
 
app = Flask(__name__)
 
@app.route('/get/signUpData/members', methods=['GET'])
def get_products():
    return jsonify({'members': members})
 
@app.route('/get/signUpData/members/randomGet', methods=['GET'])
def get_product():
    randomId = random.randint(1000,1009);
    member = [member for member in members if member['id'] == randomId]
    if len(member) == 0:
        return jsonify({'member': 'Not found'}),404
    return jsonify({'member': member})
 
@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'HTTP 404 Error': 'The content you looks for does not exist. Please check your request.'}), 404)
 
if __name__ == '__main__':
    app.run(debug=True)#!flask/bin/python