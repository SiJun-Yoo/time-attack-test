from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.test


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/detail/<idx>')
def detail(idx):
    article = db.articles.find_one({'idx': int(idx)}, {'_id': False})
    return render_template('detail.html',article=article)

# Create
@app.route('/article', methods=['POST'])
def create_article():
    title = request.form['title'];
    content = request.form['content'];
    pw = request.form['pw'];
    count = db.articles.estimated_document_count({})
    if count == 0:
        count=1
    else:
        count = (list(db.articles.find({}).sort([("id", -1)])))[0]['id'] + 1
    article = {
        'id':count,
        'title':title,
        'content':content,
        'pw':pw,
        'count':0,
        'create_date': datetime.now()
    }
    db.articles.insert_one(article)
    return {"result": "success"}

# Read
@app.route('/article', methods=['GET'])
def read_article():
    order = request.args.get('order')
    if order == 'asc':
        articles = list(db.articles.find({}, {'_id': False}).sort([("create_date", 1)]))
    else:
        articles = list(db.articles.find({}, {'_id': False}).sort([("create_date", -1)]))
    for article in articles:
        article['create_date'] = article['create_date'].strftime('%Y.%m.%d %H:%M:%S')
    return jsonify({"articles": articles})

# Update
@app.route('/article', methods=['PUT'])
def update_article():

    return {"result": "success"}

@app.route('/article/count/<id>', methods=['PUT'])
def update_article_count(id):
    count = db.articles.find_one({'id': int(id)}, {'_id': False})['count']
    db.articles.update_one({'id': id},{ "$set": { "count": int(count)+1 } })
    return {"result": "success"}

# Delete
@app.route('/article', methods=['DELETE'])
def delete_article():

    return {"result": "success"}

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)