from flask import Flask, jsonify
from datetime import datetime
from flask_cors import CORS

import requests

app = Flask(__name__)
CORS(app, resources={r"/*": {"origins": "http://localhost:5173", "credentials": True}},
     expose_headers=["Content-Type", "Content-Length", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials: true"],
     allow_headers=["Content-Type", "Content-Length", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials: true"],
     supports_credentials=True)

@app.route("/countries", methods=["GET"])
def get_countries():
    response = requests.get("https://api.covid19api.com/countries")
    countries = response.json()
    return jsonify([{"Country": country["Country"], "Slug": country["Slug"]} for country in countries])

@app.route("/compare/<country1>/<country2>/<date_init>/<date_final>", methods=["GET"])
def compare_countries(country1, country2, date_init, date_final):
    date_init = datetime.strptime(date_init, "%Y-%m-%d")
    date_final = datetime.strptime(date_final, "%Y-%m-%d")
    
    def get_statistics(country):
        response = requests.get(f"https://api.covid19api.com/country/{country}?from={date_init}&to={date_final}")
        data = response.json()
        return data[0], data[-1]
    
    statistics1_init, statistics1_final = get_statistics(country1)
    statistics2_init, statistics2_final = get_statistics(country2)
    
    country1_diff = {
        "Confirmed": statistics1_final["Confirmed"] - statistics1_init["Confirmed"],
        "Deaths": statistics1_final["Deaths"] - statistics1_init["Deaths"],
        "Recovered": statistics1_final["Recovered"] - statistics1_init["Recovered"]
    }
    
    country2_diff = {
        "Confirmed": statistics2_final["Confirmed"] - statistics2_init["Confirmed"],
        "Deaths": statistics2_final["Deaths"] - statistics2_init["Deaths"],
        "Recovered": statistics2_final["Recovered"] - statistics2_init["Recovered"]
    }
    
    return jsonify({
        country1: country1_diff,
        country2: country2_diff
    })
if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
