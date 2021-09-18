from flask import Flask, render_template, request, redirect, session
import json
import pymongo
from pymongo import MongoClient

app=Flask(__name__)

@app.route('/')
def index():
	return render_template('index.html')

@app.route('/processUserInfo/<string:userInfo>',methods=['POST'])
def processUserInfo(userInfo):
	userInfo=json.loads(userInfo)
	return userInfo

if __name__=='__main__':
	app.run(debug=True)
	data = processUserInfo()

	cluster = MongoClient("mongodb+srv://dunston:<password>@cluster0.gxvgv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority")
	db = cluster["text"]
	collection = db["test"]

	collection.insert_one(userInfo)