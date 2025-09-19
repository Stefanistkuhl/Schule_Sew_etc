const GREETING = 'iajfiasjfiajfiajf';

module.exports = async (req, res) => {
    res.send({
        greeting: GREETING,
    });
};
