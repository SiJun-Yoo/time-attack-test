from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.test


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/detail/<idx>', methods=['DELETE'])
def detail(idx):
    db.test.delete_one({"idx": idx})
    return {"result":"success"}

@app.route('/post', methods=['POST'])
def save_post():
    title = request.form['title']
    pw = request.form['pw']
    comment = request.form['comment']

    maxIdx = db.post.find().sort('idx',-1)[0]['idx'];
    print(maxIdx);
    post = {
        'idx':maxIdx+1,
        'title': title,
        'content':comment,
        'pw':pw,
        'reg_date': datetime.datetime.now()
    }

    db.test.insert_one(post)
    return jsonify({'result': 'success', 'msg': f'example "{title}" saved'})


@app.route('/post', methods=['GET'])
def get_post():
    posts = 0

    return jsonify({"posts": posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.test.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
