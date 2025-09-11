const GREETING = 'owo';

module.exports = async (req, res) => {
    res.send({
        greeting: GREETING,
    });
};
